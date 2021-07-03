package com.eiv.ui.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeCtrl {

    @GetMapping("/home")
    public String homeGet() {
        return "home";
    }
    
    @PostMapping("/home")
    public String homePost(String text) {
        log.info("Text received to convert to UPPERCASE: {}", text);
        return "home";
    }
}
