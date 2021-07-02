package com.eiv.cfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class ResourceSecurityCfg extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        // Fetched from: 
        // https://is.eivsoftware.net:9443/oauth2/oidcdiscovery/.well-known/openid-configuration

        // See: https://is.docs.wso2.com/en/latest/learn/invoke-the-oauth-introspection-endpoint/

        http
            .authorizeRequests()
                .anyRequest()
                .authenticated()
            .and()
            .sessionManagement()
                .sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS)
            .and()
            .oauth2ResourceServer(oauth2 -> {
                oauth2.opaqueToken(token -> {
                    token
                        .introspectionUri(
                            "https://is.eivsoftware.net:9443/oauth2/introspect")
                        .introspectionClientCredentials(
                            "admin", 
                            "eivrv760");
                });
            });
    }
    
}
