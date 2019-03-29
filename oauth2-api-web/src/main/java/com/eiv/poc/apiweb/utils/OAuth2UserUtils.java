package com.eiv.poc.apiweb.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import com.eiv.poc.apiweb.oauth2.OAuth2UserInfo;
import com.eiv.poc.apiweb.oauth2.OAuth2UserInfoFactory;

public class OAuth2UserUtils {

    public static OAuth2UserInfo getOAuth2UserInfo(Authentication authentication) {
        if(authentication != null && authentication.getPrincipal() instanceof DefaultOAuth2User) {
            DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
            OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(
                    oAuth2User.getAttributes());
            return userInfo;
        }
        return null;
    }
}
