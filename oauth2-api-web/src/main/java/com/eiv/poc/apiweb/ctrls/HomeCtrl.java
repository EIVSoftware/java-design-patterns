package com.eiv.poc.apiweb.ctrls;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.poc.apiweb.oauth2.OAuth2TokensInfo;
import com.eiv.poc.apiweb.oauth2.OAuth2TokensInfoService;

@RestController
public class HomeCtrl {

    private Logger LOG = LoggerFactory.getLogger(HomeCtrl.class);
    
    @Autowired 
    private OAuth2TokensInfoService oauth2TokensInfoService;
    
    @GetMapping("/home")
    public String home(Principal principal) {
        
        // InMemoryOAuth2AuthorizedClientService
        
        OAuth2TokensInfo tokensInfo = oauth2TokensInfoService.getOAuth2TokensInfo(principal.getName());
        
        if(tokensInfo != null) {
            LOG.debug("Refresh token: {}", tokensInfo.getRefreshToken());
        }
        
        return "HOME!!";
    }
}
