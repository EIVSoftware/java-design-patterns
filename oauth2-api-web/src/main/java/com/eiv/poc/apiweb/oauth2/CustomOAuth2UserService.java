package com.eiv.poc.apiweb.oauth2;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.eiv.poc.apiweb.entities.UsuarioEntity;
import com.eiv.poc.apiweb.services.UsuarioService;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    
    private static final Logger LOG = LoggerFactory.getLogger(CustomOAuth2UserService.class);

    @Autowired private UsuarioService usuarioService;
    
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        
        OAuth2User oAuth2User = super.loadUser(userRequest);
        
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory
                .getOAuth2UserInfo(oAuth2User.getAttributes());
        
        LOG.debug("Usuario: {}", userInfo.getNombreCompleto());
        
        String username = userInfo.getUsername();
        Optional<UsuarioEntity> optional = usuarioService.findyByUsername(username);
        
        if(optional.isPresent()) {
            UsuarioEntity usuarioEntity = optional.get();
            usuarioService.actualizacion(
                    usuarioEntity.getId(), 
                    userInfo.getNombreCompleto(), 
                    userInfo.getEmail());
        } else {
            usuarioService.alta(
                    username, 
                    userInfo.getNombreCompleto(), 
                    userInfo.getEmail());
        }
        
        return oAuth2User;
    }
}
