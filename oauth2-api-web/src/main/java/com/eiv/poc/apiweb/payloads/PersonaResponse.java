package com.eiv.poc.apiweb.payloads;

public class PersonaResponse {

    private Long id;
    private String nombres;
    private String apellidos;
    
    public PersonaResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "PersonaResponse [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + "]";
    }
    
}
