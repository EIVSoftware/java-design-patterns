package com.eiv.ui.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.ui.model.ResponseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class StringCtrl {
    
    @GetMapping("/touppercase")
    public ResponseEntity<ResponseModel> toUpperCase(String msg, Authentication auth) {
        
    	Jwt principal = (Jwt) auth.getPrincipal();
    	log.info("Authenticated user: {}", principal.getClaim("name").toString());
    	
        ResponseModel response = new ResponseModel(msg == null ? null : msg.trim().toUpperCase());
        return ResponseEntity.ok(response);
    }
}
