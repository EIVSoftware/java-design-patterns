package com.eiv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.data.model.LineaEntity;
import com.eiv.data.pk.LineaPkEntity;

public interface LineaRepository extends
        JpaRepository<LineaEntity, LineaPkEntity>,
        QuerydslPredicateExecutor<LineaEntity> {

}
