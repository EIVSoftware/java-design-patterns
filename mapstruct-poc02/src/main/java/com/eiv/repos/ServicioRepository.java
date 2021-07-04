package com.eiv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.data.model.ServicioEntity;
import com.eiv.data.pk.ServicioPkEntity;

public interface ServicioRepository extends
        JpaRepository<ServicioEntity, ServicioPkEntity>,
        QuerydslPredicateExecutor<ServicioEntity> {

}
