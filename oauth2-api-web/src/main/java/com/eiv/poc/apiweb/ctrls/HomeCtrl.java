package com.eiv.poc.apiweb.ctrls;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCtrl {

    private Logger LOG = LoggerFactory.getLogger(HomeCtrl.class);
    
    @Autowired 
    private InMemoryOAuth2AuthorizedClientService authorizedClientService;
    
    @GetMapping("/home")
    public String home(Principal principal) {
        
        // InMemoryOAuth2AuthorizedClientService
        
        OAuth2AuthorizedClient authorizedClient = authorizedClientService
                .loadAuthorizedClient("eivas", principal.getName());
        
        LOG.debug("Refresh token: {}", 
                authorizedClient.getRefreshToken().getTokenValue());
        return "HOME!!";
    }
}
