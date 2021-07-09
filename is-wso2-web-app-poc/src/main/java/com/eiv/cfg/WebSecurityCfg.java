package com.eiv.cfg;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@EnableWebSecurity
public class WebSecurityCfg extends WebSecurityConfigurerAdapter {

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
    	        return clientRegistrationRepository.findByRegistrationId("auth0");
    	    }
    		
			@Override
			public void logout(
					HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

		        // Invalidate the session and clear the security context
		        super.logout(request, response, authentication);

		        // Build the URL to log the user out of Auth0 and redirect them to the home page.
		        // URL will look like https://YOUR-DOMAIN/v2/logout?clientId=YOUR-CLIENT-ID&returnTo=http://localhost:3000
		        
		        String issuer = (String) getClientRegistration().getProviderDetails().getConfigurationMetadata().get("issuer");
		        String clientId = getClientRegistration().getClientId();
		        String returnTo = ServletUriComponentsBuilder.fromCurrentContextPath().build().toString();

		        String logoutUrl = UriComponentsBuilder
		                .fromHttpUrl(issuer + "v2/logout?client_id={clientId}&returnTo={returnTo}")
		                .encode()
		                .buildAndExpand(clientId, returnTo)
		                .toUriString();

	            try {
					response.sendRedirect(logoutUrl);
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
    	};
    }
}
