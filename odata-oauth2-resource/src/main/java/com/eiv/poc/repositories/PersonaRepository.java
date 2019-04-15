package com.eiv.poc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.poc.entities.PersonaEntity;

public interface PersonaRepository extends 
        JpaRepository<PersonaEntity, Long>, QuerydslPredicateExecutor<PersonaEntity> {

    @Query("SELECT MAX(e.id) FROM PersonaEntity e")
    public Long getMaxId();
}
