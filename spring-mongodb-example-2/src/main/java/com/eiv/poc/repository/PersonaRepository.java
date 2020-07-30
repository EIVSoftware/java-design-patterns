package com.eiv.poc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.poc.doc.PersonaDoc;

public interface PersonaRepository extends 
        MongoRepository<PersonaDoc, String>, 
        QuerydslPredicateExecutor<PersonaDoc> {
    
    List<PersonaDoc> findByNombre(String nombre);

}
