package com.eiv.poc.apiweb.ctrls;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.poc.apiweb.payloads.EchoResponse;

@RestController
public class EchoCtrl {

    @GetMapping("/echo")
    public EchoResponse echo(@RequestParam("msg") String msg) {
        return new EchoResponse(msg);
    }
}
