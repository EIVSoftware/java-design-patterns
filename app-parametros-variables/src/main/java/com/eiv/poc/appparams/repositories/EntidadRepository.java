package com.eiv.poc.appparams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiv.poc.appparams.entities.EntidadEntity;

public interface EntidadRepository extends JpaRepository<EntidadEntity, Long> {

}
