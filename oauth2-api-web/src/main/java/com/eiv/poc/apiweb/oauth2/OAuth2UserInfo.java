package com.eiv.poc.apiweb.oauth2;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

public class OAuth2UserInfo {

    private Long id = null;
    private String username;
    private String nombres;
    private String apellidos;
    private String nombreCompleto;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private LocalDate fechaNacimiento;
    private SexoEnum sexo;
    private Pais nacionalidad;
    private EstadoCivilEnum estadoCivil;
    private String email;
    private Domicilio domicilio;
    
    public OAuth2UserInfo() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public Pais getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Pais nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public EstadoCivilEnum getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
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
        OAuth2UserInfo other = (OAuth2UserInfo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OAuthUserInfoEndPointResponse [id=" + id + ", username=" + username + "]";
    }
    
    
    public enum SexoEnum {
        MASCULINO,
        FEMENINO;
    }
    
    public enum EstadoCivilEnum {
        SOLTERO,
        CASADO,
        VIUDO,
        DIVORSIADO;
    }
    
    public static class TipoDocumento {

        private Long id = null;
        private String nombre = null;
        private String abreviatura = null;
        private String claveExterna = null;

        public TipoDocumento() {
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

        public String getAbreviatura() {
            return abreviatura;
        }

        public void setAbreviatura(String abreviatura) {
            this.abreviatura = abreviatura;
        }

        public String getClaveExterna() {
            return claveExterna;
        }

        public void setClaveExterna(String claveExterna) {
            this.claveExterna = claveExterna;
        }
        
    }
    
    public static class Pais {

        private Long id = null;
        private String nombre = null;
        private String nacionalidad = null;
        private String locale = null;
        private String claveExterna = null;

        public Pais() {
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

        public String getNacionalidad() {
            return nacionalidad;
        }

        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getClaveExterna() {
            return claveExterna;
        }

        public void setClaveExterna(String claveExterna) {
            this.claveExterna = claveExterna;
        }
        
    }
    
    public static class Provincia {

        private Long id;
        private String nombre;
        private String claveExterna;
        private Pais pais;
        
        public Provincia() {
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

        public String getClaveExterna() {
            return claveExterna;
        }

        public void setClaveExterna(String claveExterna) {
            this.claveExterna = claveExterna;
        }

        public Pais getPais() {
            return pais;
        }

        public void setPais(Pais pais) {
            this.pais = pais;
        }
    }
    
    public static class Localidad {

        private Long id;
        private String nombre;
        private String cp;
        private String claveExterna;
        private Provincia provincia;
        
        public Localidad() {
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

        public String getCp() {
            return cp;
        }

        public void setCp(String cp) {
            this.cp = cp;
        }

        public String getClaveExterna() {
            return claveExterna;
        }

        public void setClaveExterna(String claveExterna) {
            this.claveExterna = claveExterna;
        }

        public Provincia getProvincia() {
            return provincia;
        }

        public void setProvincia(Provincia provincia) {
            this.provincia = provincia;
        }
        
    }

    public static class Domicilio {
    
        private String calle;
        private String nro;
        private String piso;
        private String depto;
        private Localidad localidad;
        
        public Domicilio() {
        }

        public Domicilio(String calle, String nro, String piso, 
                String depto, Localidad localidad) {
            super();
            this.calle = calle;
            this.nro = nro;
            this.piso = piso;
            this.depto = depto;
            this.localidad = localidad;
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

        public String getPiso() {
            return piso;
        }

        public void setPiso(String piso) {
            this.piso = piso;
        }

        public String getDepto() {
            return depto;
        }

        public void setDepto(String depto) {
            this.depto = depto;
        }

        public Localidad getLocalidad() {
            return localidad;
        }

        public void setLocalidad(Localidad localidad) {
            this.localidad = localidad;
        }

        @Override
        public String toString() {
            return "Domicilio [calle=" + calle + ", nro=" + nro + "]";
        }
    }
}
