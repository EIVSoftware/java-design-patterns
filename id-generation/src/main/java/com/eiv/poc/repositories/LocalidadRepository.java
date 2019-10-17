package com.eiv.poc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.poc.entities.LocalidadEntity;

public interface LocalidadRepository extends 
        JpaRepository<LocalidadEntity, Long>, QuerydslPredicateExecutor<LocalidadEntity> {

}
