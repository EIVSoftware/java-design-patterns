package com.eiv.poc.apiweb.ctrls;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eiv.poc.apiweb.payloads.PersonaResponse;

@RestController
public class PersonasCtrl {

    @Autowired protected RestTemplateBuilder restTemplateBuilder;
    
    @GetMapping("/personas")
    public List<PersonaResponse> buscarPersonas() {
        
        RestTemplate restTemplate = restTemplateBuilder
                .build();
        
        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
            
            @Override
            public ClientHttpResponse intercept(
                    HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                request.getHeaders().set("Authorization", String.format(
                        "Bearer %s", "0e35f95d-2883-4d42-9ca5-bb779cf3405e"));
                return execution.execute(request, body);
            }
        });
        
        ResponseEntity<List<PersonaResponse>> response = restTemplate.exchange(
          "http://localhost:5000/api/personas/",
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<List<PersonaResponse>>(){});
        
        List<PersonaResponse> personaResponses = response.getBody();
        
        return personaResponses;
    }
}
