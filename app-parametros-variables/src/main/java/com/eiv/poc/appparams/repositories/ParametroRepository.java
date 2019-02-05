package com.eiv.poc.appparams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiv.poc.appparams.entities.ParametroEntity;
import com.eiv.poc.appparams.entities.ParametroPKEntity;

public interface ParametroRepository extends JpaRepository<ParametroEntity, ParametroPKEntity> {

}
