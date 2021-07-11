package com.eiv.cfg;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@EnableWebSecurity
public class WebSecurityCfg extends WebSecurityConfigurerAdapter {

	private final String idp;
	
	public WebSecurityCfg(@Value("${app.idp}") String idp) {
		this.idp = idp;
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/login", "/webjars/**")
                    .permitAll()
                .anyRequest()
                    .authenticated()
            .and()
            .oauth2Login()
                .loginPage("/login")
            .and()
            .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .addLogoutHandler(securityContextLogoutHandler())
                ;
        
    }

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    
    public SecurityContextLogoutHandler securityContextLogoutHandler() {
    	
    	return new SecurityContextLogoutHandler() {

    		private ClientRegistration getClientRegistration() {
    	        return clientRegistrationRepository.findByRegistrationId(idp);
    	    }
    		
			@Override
			public void logout(
					HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

				OidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();
	        	final String accessToken = oidcUser.getIdToken().getTokenValue();
				
		        // Invalidate the session and clear the security context
		        super.logout(request, response, authentication);

		        // Build the URL to log the user out of Id prodiver and redirect them to the home page.
		        
		        // AUTH0 URL: https://YOUR-DOMAIN/v2/logout?clientId=YOUR-CLIENT-ID&returnTo=http://somewhere.com
		        // IS WSO2 URL: https://is.eivsoftware.net:9443/oidc/logout
		        
		        String logoutUrl = getLogoutUrl(getClientRegistration(), accessToken);
		        
	            try {
					response.sendRedirect(logoutUrl);
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
			
			private String getLogoutUrl(ClientRegistration client, String accessToken) {

		        String returnTo = ServletUriComponentsBuilder
		        		.fromCurrentContextPath()
		        		.build()
		        		.toString();
		        
				if ("wso2".equals(client.getRegistrationId())) {
					
					String logoutEndpoint = (String) getClientRegistration()
							.getProviderDetails()
							.getConfigurationMetadata()
							.get("end_session_endpoint");
					
					String logoutUrl = UriComponentsBuilder
			        		.fromHttpUrl(
			        				logoutEndpoint + "?post_logout_redirect_uri={returnTo}&id_token_hint={tokenId}")
			                .encode()
			                .buildAndExpand(returnTo, accessToken)
			                .toUriString();;
					
					return logoutUrl;
				}
				
				if ("auth0".equals(client.getRegistrationId())) {
					
					String issuer = (String) getClientRegistration()
							.getProviderDetails()
							.getConfigurationMetadata()
							.get("issuer");
					
					String clientId = client.getClientId();
					
			        String logoutUrl = UriComponentsBuilder
			        		.fromHttpUrl(issuer + "v2/logout?client_id={clientId}&returnTo={returnTo}")
			                .encode()
			                .buildAndExpand(clientId, returnTo)
			                .toUriString();

					return logoutUrl;
				}
				
				throw new RuntimeException("Client unknown!");
			}
    	};
    }
}
