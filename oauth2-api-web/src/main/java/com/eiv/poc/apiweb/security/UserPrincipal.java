package com.eiv.poc.apiweb.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eiv.poc.apiweb.entities.UsuarioEntity;

public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id = null;    
    private String nombres = null;
    private String correo = null;
    private String username = null;
    private Boolean habilitado = null;
    private Collection<? extends GrantedAuthority> authorities;
    
    public UserPrincipal(Long id, String nombres, String correo, String username, 
            Boolean habilitado, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.id = id;
        this.nombres = nombres;
        this.correo = correo;
        this.username = username;
        this.habilitado = habilitado;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    @Override
    public String getPassword() {
        return null;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return habilitado;
    }
    
    public static UserPrincipal create(UsuarioEntity usuarioEntity) {
        
        List<GrantedAuthority> authorities = usuarioEntity.getGrantedAuthorities().stream()
            .map(authority ->
                new SimpleGrantedAuthority(authority.getAuthority()))
            .collect(Collectors.toList());
                
        return new UserPrincipal(
                usuarioEntity.getId(),
                usuarioEntity.getNombreCompleto(),
                usuarioEntity.getCorreo(),
                usuarioEntity.getUsername(),
                usuarioEntity.getHabilitado(),
                authorities
        );
    }
}
