package com.eiv.poc.apiweb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity @Table(name="usuarios", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"}, name = "IX_usuarios_username")
})
public class UsuarioEntity {
    
    @Id @Column(name="id")
    private Long id = null;
    
    @Column(name="username", length=100, nullable=false, unique=true)
    private String username = null;
    
    @Column(name="nombre_completo", length=200, nullable=false)
    private String nombreCompleto = null;
    
    @Column(name="correo", length=300, nullable=true)
    private String correo = null;
    
    @Column(name="habilitado", nullable=false)
    private Boolean habilitado = false;
    
    @ManyToMany(fetch = FetchType.LAZY) @JoinTable(
        name = "usuarios_authorities",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<AuthorityEntity> grantedAuthorities = new HashSet<>();
    
    public UsuarioEntity() {}

    public UsuarioEntity(Long id, String username, String nombreCompleto, String correo) {
        super();
        this.id = id;
        this.username = username;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }
    
    public UsuarioEntity(String username, String nombres, String correo) {
        this(null, username, nombres, correo);
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Set<AuthorityEntity> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(Set<AuthorityEntity> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
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
        UsuarioEntity other = (UsuarioEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioEntity [id=" + id + ", username=" + username + "]";
    }
}
