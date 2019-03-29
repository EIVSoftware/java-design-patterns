package com.eiv.poc.apiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eiv.poc.apiweb.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query("SELECT MAX(e.id) FROM UsuarioEntity e")
    Long getMaxId();
    
    @Query("SELECT e FROM UsuarioEntity e WHERE e.username = ?1")
    UsuarioEntity findByUsername(String username);
}
