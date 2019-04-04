package com.eiv.poc.ad.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCtrl {

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
