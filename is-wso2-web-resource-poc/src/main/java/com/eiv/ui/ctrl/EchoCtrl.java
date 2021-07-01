package com.eiv.ui.ctrl;

import com.eiv.ui.model.EchoModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EchoCtrl {
    
    @GetMapping("/echo")
    public ResponseEntity<EchoModel> sendEcho(String msg) {
        EchoModel response = new EchoModel(msg);
        return ResponseEntity.ok(response);
    }
}
