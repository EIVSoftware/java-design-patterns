package com.eiv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.data.model.CuentaVistaAcuerdoEntity;

public interface CuentaVistaAcuerdoRepository extends
        JpaRepository<CuentaVistaAcuerdoEntity, Long>,
        QuerydslPredicateExecutor<CuentaVistaAcuerdoEntity> {

}
