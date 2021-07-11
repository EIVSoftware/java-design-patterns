package com.eiv.ui.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginCtrl {
	
	@Value("${app.idp}") 
	private String idp;
	
    @GetMapping("/login")
    public String loginFrm() {
        return "login";
    }
    
    @PostMapping("/login")
    public String loginPost() {
        return "redirect:/oauth2/authorization/" + idp;
    }
}
