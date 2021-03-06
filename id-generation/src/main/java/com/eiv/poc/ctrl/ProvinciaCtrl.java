package com.eiv.poc.ctrl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.poc.entities.ProvinciaEntity;
import com.eiv.poc.payloads.requests.ProvinciaRequest;
import com.eiv.poc.payloads.responses.ProvinciaResponse;
import com.eiv.poc.services.ProvinciaService;

@RestController
@RequestMapping("/provincias")
public class ProvinciaCtrl {
    
    @Autowired
    private ProvinciaService service;
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProvinciaResponse> buscar(@PathVariable(name = "id") Long id) {
        ProvinciaEntity entity = service.buscarPorId(id).orElseThrow(RuntimeException::new);
        ProvinciaResponse response = new ProvinciaResponse(entity);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<ProvinciaResponse>> buscar() {
        List<ProvinciaEntity> entities = service.buscar();
        List<ProvinciaResponse> response = 
                entities.stream().map(ProvinciaResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
    
    @PostMapping
    public ResponseEntity<ProvinciaResponse> alta(@RequestBody ProvinciaRequest request) {
        ProvinciaEntity entity = service.alta(request.getNombre());
        ProvinciaResponse response = new ProvinciaResponse(entity);
        return ResponseEntity.ok(response);
    }
}
