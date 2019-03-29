package com.eiv.poc.apiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eiv.poc.apiweb.entities.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {

    @Query("SELECT MAX(e.id) FROM AuthorityEntity e")
    Long getMaxId();
}
