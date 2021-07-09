package com.eiv.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import com.eiv.data.services.ToUpperCaseService;

@Configuration
public class ToUpperCaseServiceCfg {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

    @Bean
    @RequestScope
    public ToUpperCaseService getToUpperCaseService(OAuth2AuthorizedClientService clientService) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = null;

        if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {

            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            String clientRegistrationId = oauthToken.getAuthorizedClientRegistrationId();

            if (clientRegistrationId.equals("auth0")) {

            	OidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();
            	accessToken = oidcUser.getIdToken().getTokenValue();
            }
        }

        return new ToUpperCaseService(getRestTemplate(), accessToken);
    }
}
