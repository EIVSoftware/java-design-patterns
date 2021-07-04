package com.eiv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.data.model.CuentaVistaEntity;

public interface CuentaVistaRepository extends
        JpaRepository<CuentaVistaEntity, Long>,
        QuerydslPredicateExecutor<CuentaVistaEntity> {

}
