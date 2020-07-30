package com.eiv.poc.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.poc.docs.PersonaDoc;

public interface PersonaRepository extends 
        MongoRepository<PersonaDoc, String>, 
        QuerydslPredicateExecutor<PersonaDoc> {
    
    List<PersonaDoc> findByNombre(String nombre);

}
