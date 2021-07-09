package com.eiv.ui.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eiv.data.services.ToUpperCaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeCtrl {

    @Autowired private ToUpperCaseService service;
    
    @GetMapping("/home")
    public String homeGet(@AuthenticationPrincipal DefaultOAuth2User principal, Model model) {
        String username = principal.getName();
        model.addAttribute("username", username);
        return "home";
    }
    
    @PostMapping("/home")
    public String homePost(
            @AuthenticationPrincipal DefaultOAuth2User principal, String text, Model model) {
        
        log.info("Text received to convert to UPPERCASE: {}", text);
        
        String result = service.toUpperCase(text);
        log.info("Result: {}", result);
        
        model.addAttribute("result", result);
        
        String username = principal.getName();
        model.addAttribute("username", username);
        
        return "result";
    }
}
