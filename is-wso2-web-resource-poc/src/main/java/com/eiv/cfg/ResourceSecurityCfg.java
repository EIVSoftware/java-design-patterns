package com.eiv.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class ResourceSecurityCfg extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.oauth2.resourceserver.opaquetoken.introspection-uri}")
    private String introspectionEndpoint;
    
    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-id}")
    private String introspectionClientId;
    
    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-secret}")
    private String introspectionClientSecret;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        // Fetched from: 
        // https://is.eivsoftware.net:9443/oauth2/oidcdiscovery/.well-known/openid-configuration

        // See: https://is.docs.wso2.com/en/latest/learn/invoke-the-oauth-introspection-endpoint/

        http
            .authorizeRequests()
                .antMatchers(
                    "/error/**",
                    "/actuator/**",
                    "/v3/api-docs/**",
                    "/swagger-ui/**", "/swagger-ui.html/**", "/swagger-resources/**"
                    )
                .permitAll()
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
                        .introspectionUri(introspectionEndpoint)
                        .introspectionClientCredentials(
                            introspectionClientId, 
                            introspectionClientSecret);
                });
            });
    }
    
}
