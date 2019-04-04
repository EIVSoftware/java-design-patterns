package com.eiv.poc.ad.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String URL = "ldap://192.168.1.224:389";
    private static final String DOMAIN = "eivsoftware2.net";
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
            .anyRequest().fullyAuthenticated()
            .and()
        .formLogin()
            .defaultSuccessUrl("/home")
        .and()
        .logout()
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        ActiveDirectoryLdapAuthenticationProvider provider = new 
                ActiveDirectoryLdapAuthenticationProvider(DOMAIN, URL);
        
        provider.setConvertSubErrorCodesToExceptions(true);
        provider.setUseAuthenticationRequestCredentials(true);
        
        auth.authenticationProvider(provider);
        auth.eraseCredentials(false);
    }
}
