package com.eiv.poc.apiresource.api.payload;

import com.eiv.poc.apiresource.entities.PersonaEntity;

public class PersonaResponse {

    private Long id;
    private String nombres;
    private String apellidos;
    
    public PersonaResponse() {
    }
    
    public PersonaResponse(PersonaEntity personaEntity) {
        this.id = personaEntity.getId();
        this.nombres = personaEntity.getNombres();
        this.apellidos = personaEntity.getApellidos();
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonaResponse other = (PersonaResponse) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PersonaResponse [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + "]";
    }
    
}
