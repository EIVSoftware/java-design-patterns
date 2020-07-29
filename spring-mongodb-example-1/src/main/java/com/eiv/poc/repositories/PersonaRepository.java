package com.eiv.poc.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eiv.poc.docs.PersonaDoc;

public interface PersonaRepository extends MongoRepository<PersonaDoc, String> {
    
    List<PersonaDoc> findByNombre(String nombre);

}
