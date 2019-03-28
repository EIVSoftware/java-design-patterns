package com.eiv.poc.apiweb.ctrls;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCtrl {

    @GetMapping("/home")
    public String home() {
        return "HOME!!";
    }
}
