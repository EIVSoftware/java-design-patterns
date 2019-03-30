package com.eiv.poc.apiresource.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eiv.poc.apiresource.entities.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

    @Query("SELECT MAX(e.id) FROM PersonaEntity e")
    public Long getMaxId();
}
