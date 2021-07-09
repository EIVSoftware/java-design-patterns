package com.eiv.ui.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginCtrl {

    @GetMapping("/login")
    public String loginFrm() {
        return "login";
    }
    
    @PostMapping("/login")
    public String loginPost() {
        //return "redirect:/oauth2/authorization/wso2";
    	return "redirect:/oauth2/authorization/auth0";
    }
}
