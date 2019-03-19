package com.eiv.poc.jaspernestedreport;

import java.util.Collection;

public interface PersonaBean {

    public Long getId();

    public void setId(Long id);

    public String getNombre();

    public void setNombre(String nombre);

    public Collection<? extends PersonaDireccionBean> getDirecciones();
    
    public void setDirecciones(Collection<? extends PersonaDireccionBean> direcciones);
    
}
