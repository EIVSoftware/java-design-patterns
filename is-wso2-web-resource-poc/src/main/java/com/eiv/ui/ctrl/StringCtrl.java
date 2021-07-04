package com.eiv.ui.ctrl;

import com.eiv.ui.model.ResponseModel;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionAuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class StringCtrl {
    
    @GetMapping("/touppercase")
    public ResponseEntity<ResponseModel> toUpperCase(String msg, Authentication auth) {
        
        OAuth2IntrospectionAuthenticatedPrincipal principal = 
        (OAuth2IntrospectionAuthenticatedPrincipal) auth.getPrincipal();
        
        log.info("Authenticated user: {}", principal.getUsername());

        ResponseModel response = new ResponseModel(msg == null ? null : msg.trim().toUpperCase());
        return ResponseEntity.ok(response);
    }
}
