package com.eiv.poc.apiresource.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.poc.apiresource.entities.PersonaEntity;
import com.eiv.poc.apiresource.repositories.PersonaRepository;

@Service
public class PersonaService {

    @Autowired private PersonaRepository personaRepository;
    
    @Transactional(readOnly=true)
    public List<PersonaEntity> findAll() {
        return personaRepository.findAll();
    }
}
