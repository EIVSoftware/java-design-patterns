package com.eiv.poc.edm.resources;

import com.cairone.olingo.ext.jpa.annotations.EdmEntity;
import com.cairone.olingo.ext.jpa.annotations.EdmEntitySet;
import com.cairone.olingo.ext.jpa.annotations.EdmProperty;
import com.cairone.olingo.ext.jpa.annotations.ODataQueryDslEntity;
import com.eiv.poc.AppConstants;
import com.eiv.poc.entities.PersonaEntity;

@EdmEntity(name = "Persona", key = "Id", namespace = AppConstants.NAME_SPACE, containerName = AppConstants.CONTAINER_NAME)
@EdmEntitySet("Personas")
@ODataQueryDslEntity(jpaentity=PersonaEntity.class, variable="personaEntity")
public class PersonaEdm {
	
	@EdmProperty(nullable=false)
	private Long id = null;
	
	@EdmProperty(nullable=false)
	private String nombres = null;

	@EdmProperty(nullable=false)
    private String apellidos = null;
	
	public PersonaEdm() {}

	public PersonaEdm(PersonaEntity personaEntity) {
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
        PersonaEdm other = (PersonaEdm) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PersonaEdm [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + "]";
    }

}
