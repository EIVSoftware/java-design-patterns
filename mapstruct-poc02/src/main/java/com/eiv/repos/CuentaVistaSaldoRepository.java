package com.eiv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.data.model.CuentaVistaSaldoEntity;

public interface CuentaVistaSaldoRepository extends
        JpaRepository<CuentaVistaSaldoEntity, Long>,
        QuerydslPredicateExecutor<CuentaVistaSaldoEntity> {

}
