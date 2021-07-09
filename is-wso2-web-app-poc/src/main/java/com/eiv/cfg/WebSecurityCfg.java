package com.eiv.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

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
                .logoutSuccessHandler(oidcLogoutSuccessHandler());
        
    }

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    private LogoutSuccessHandler oidcLogoutSuccessHandler() {
        
        OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
                new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);

        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("http://localhost:8080/login");

        return oidcLogoutSuccessHandler;
    }
}
