package com.eiv.poc.apiweb.ctrls;

import java.io.IOException;
import java.security.Principal;
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

import com.eiv.poc.apiweb.oauth2.OAuth2TokensInfo;
import com.eiv.poc.apiweb.oauth2.OAuth2TokensInfoService;
import com.eiv.poc.apiweb.payloads.PersonaResponse;

@RestController
public class PersonasCtrl {

    private static final String PERSONAS_ENDPOINT_URL = "http://localhost:5000/api/personas/";
    
    @Autowired private RestTemplateBuilder restTemplateBuilder;
    @Autowired private OAuth2TokensInfoService oauth2TokensInfoService;
    
    @GetMapping("/personas")
    public List<PersonaResponse> buscarPersonas(Principal principal) {
        
        String username = principal.getName();
        RestTemplate restTemplate = restTemplateBuilder.build();
        
        OAuth2TokensInfo tokensInfo = oauth2TokensInfoService.getOAuth2TokensInfo(username);
        String accessToken = tokensInfo == null ? null : tokensInfo.getAccessToken();
        
        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
            
            @Override
            public ClientHttpResponse intercept(
                HttpRequest request, byte[] body, ClientHttpRequestExecution execution) 
                        throws IOException {
                
                request
                    .getHeaders()
                    .set("Authorization", String.format("Bearer %s", accessToken));
                
                return execution.execute(request, body);
            }
        });
        
        ResponseEntity<List<PersonaResponse>> response = restTemplate.exchange(
          PERSONAS_ENDPOINT_URL,
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<List<PersonaResponse>>(){});
        
        List<PersonaResponse> personaResponses = response.getBody();
        
        return personaResponses;
    }
}
