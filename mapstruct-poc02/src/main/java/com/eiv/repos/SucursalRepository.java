package com.eiv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.data.model.SucursalEntity;

public interface SucursalRepository
        extends JpaRepository<SucursalEntity, Long>, QuerydslPredicateExecutor<SucursalEntity> {

}
