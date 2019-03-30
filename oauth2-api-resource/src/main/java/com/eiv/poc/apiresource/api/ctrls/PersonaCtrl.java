package com.eiv.poc.apiresource.api.ctrls;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.poc.apiresource.api.payload.PersonaResponse;
import com.eiv.poc.apiresource.services.PersonaService;

@RestController
public class PersonaCtrl {

    @Autowired private PersonaService personaService;
    
    @GetMapping("/api/personas")
    public List<PersonaResponse> listarPersonas() {
        return personaService.findAll().stream()
                .map(e -> new PersonaResponse(e))
                .collect(Collectors.toList());
    }
}
