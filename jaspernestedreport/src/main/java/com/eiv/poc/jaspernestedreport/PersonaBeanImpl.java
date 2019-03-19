package com.eiv.poc.jaspernestedreport;

import java.util.ArrayList;
import java.util.Collection;

public class PersonaBeanImpl implements PersonaBean {

    private Long id;
    private String nombre;
    private Collection<? extends PersonaDireccionBean> direcciones;
    
    public PersonaBeanImpl() {
    }

    public PersonaBeanImpl(Long id, String nombre, 
            Collection<? extends PersonaDireccionBean> direcciones) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.direcciones = direcciones;
    }
    
    public PersonaBeanImpl(Long id, String nombre) {
        this(id, nombre, new ArrayList<PersonaDireccionBean>());
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

    public Collection<? extends PersonaDireccionBean> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Collection<? extends PersonaDireccionBean> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        return "PersonaBeanImpl [id=" + id + ", nombre=" + nombre + "]";
    }
}
