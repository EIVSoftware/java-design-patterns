package com.eiv.poc.apiweb.ctrls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCtrl {

    private Logger LOG = LoggerFactory.getLogger(HomeCtrl.class);
    
    @GetMapping("/home")
    public String home(
            @RegisteredOAuth2AuthorizedClient("eivas") OAuth2AuthorizedClient authorizedClient) {
        
        LOG.debug("Refresh token: {}", 
                authorizedClient.getRefreshToken().getTokenValue());
        return "HOME!!";
    }
}
