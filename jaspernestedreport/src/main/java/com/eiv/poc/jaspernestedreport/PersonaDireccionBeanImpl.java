package com.eiv.poc.jaspernestedreport;

public class PersonaDireccionBeanImpl implements PersonaDireccionBean {

    private String calle;
    private String nro;
    
    public PersonaDireccionBeanImpl() {
    }

    public PersonaDireccionBeanImpl(String calle, String nro) {
        super();
        this.calle = calle;
        this.nro = nro;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    @Override
    public String toString() {
        return "PersonaDireccionBeanImpl [calle=" + calle + ", nro=" + nro + "]";
    }
    
}
