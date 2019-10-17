package com.eiv.poc.payloads.responses;

import com.eiv.poc.entities.ProvinciaEntity;

public class ProvinciaResponse {
    
    private Long id;
    private String nombre;
    
    public ProvinciaResponse(ProvinciaEntity entity) {
        id = entity.getId();
        nombre = entity.getNombre();
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
