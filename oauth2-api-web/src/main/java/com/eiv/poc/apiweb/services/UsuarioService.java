package com.eiv.poc.apiweb.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.poc.apiweb.entities.AuthorityEntity;
import com.eiv.poc.apiweb.entities.UsuarioEntity;
import com.eiv.poc.apiweb.repositories.AuthorityRepository;
import com.eiv.poc.apiweb.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Value("${app.default-authority-id}")
    private Long defaultAuthorityId;
    
    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private AuthorityRepository authorityRepository;
    
    @Transactional(readOnly = true)
    public Optional<UsuarioEntity> findyByUsername(String username) {
        return Optional.ofNullable(usuarioRepository.findByUsername(username));
    }
    
    @Transactional(readOnly = true)
    public Optional<UsuarioEntity> findyById(Long id) {
        return usuarioRepository.findById(id);
    }
    
    @Transactional
    public UsuarioEntity alta(String username, String nombreCompleto, String correo) {
        
        Long id = usuarioRepository.getMaxId();
        
        if(id == null) {
            id = 0L;
        }
        id += 1L;
        
        Set<AuthorityEntity> grantedAuthorities = new HashSet<AuthorityEntity>();
        
        authorityRepository.findById(defaultAuthorityId).ifPresent(authority -> {
            grantedAuthorities.add(authority);
        });
        
        UsuarioEntity usuarioEntity = new UsuarioEntity(id, username, nombreCompleto, correo);
        usuarioEntity.setHabilitado(true);
        usuarioEntity.setGrantedAuthorities(grantedAuthorities);
        
        usuarioRepository.save(usuarioEntity);
        
        return usuarioEntity;
    }

    @Transactional
    public UsuarioEntity actualizacion(
            Long id, String nombreCompleto, String correo) {
        
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(id);
        
        if(!usuarioOptional.isPresent()) {
            throw new RuntimeException(
                String.format("No existe un usuario con ID %s", id));
        }
        
        UsuarioEntity usuarioEntity = usuarioOptional.get();
        
        usuarioEntity.setCorreo(correo);
        usuarioEntity.setHabilitado(true);
        usuarioEntity.setNombreCompleto(nombreCompleto);
        
        usuarioRepository.save(usuarioEntity);
        
        return usuarioEntity;
    }
}
