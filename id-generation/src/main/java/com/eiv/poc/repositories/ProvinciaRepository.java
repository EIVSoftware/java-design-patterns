package com.eiv.poc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.poc.entities.ProvinciaEntity;

public interface ProvinciaRepository extends 
        JpaRepository<ProvinciaEntity, Long>, QuerydslPredicateExecutor<ProvinciaEntity> {

}
