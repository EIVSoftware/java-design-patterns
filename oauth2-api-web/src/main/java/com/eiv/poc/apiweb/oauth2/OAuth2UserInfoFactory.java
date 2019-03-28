package com.eiv.poc.apiweb.oauth2;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(Map<String, Object> attributes) {
        
        ObjectMapper mapper = new ObjectMapper();
        OAuth2UserInfo userInfo = mapper.convertValue(attributes, OAuth2UserInfo.class);
        
        return userInfo;
    }
}
