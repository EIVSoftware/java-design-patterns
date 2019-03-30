package com.eiv.poc.apiweb.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.stereotype.Service;

@Service
public class OAuth2TokensInfoService {

    @Autowired 
    private InMemoryOAuth2AuthorizedClientService authorizedClientService;
    
    @Value("${spring.security.oauth2.client.registration.eivas.provider}")
    private String providerId;
    
    public OAuth2TokensInfo getOAuth2TokensInfo(String username) {
        
        OAuth2AuthorizedClient authorizedClient = authorizedClientService
                .loadAuthorizedClient(providerId, username);
        
        if(authorizedClient == null) {
            return null;
        }
        
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        OAuth2RefreshToken refreshToken = authorizedClient.getRefreshToken();
        
        if(refreshToken == null) {
            return new OAuth2TokensInfo(accessToken.getTokenValue());
        } else {
            return new OAuth2TokensInfo(accessToken.getTokenValue(), refreshToken.getTokenValue());
        }
    }
}
