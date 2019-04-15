package com.eiv.poc.odata.datasources;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.apache.olingo.server.api.ODataApplicationException;
import org.apache.olingo.server.api.uri.UriParameter;
import org.apache.olingo.server.api.uri.queryoption.ExpandOption;
import org.apache.olingo.server.api.uri.queryoption.SelectOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairone.olingo.ext.jpa.interfaces.DataSource;
import com.cairone.olingo.ext.jpa.interfaces.QueryOptions;
import com.cairone.olingo.ext.jpa.query.QuerydslQuery;
import com.cairone.olingo.ext.jpa.query.QuerydslQueryBuilder;
import com.eiv.poc.edm.resources.PersonaEdm;
import com.eiv.poc.entities.PersonaEntity;
import com.eiv.poc.repositories.PersonaRepository;

@Component
public class PersonaDataSource implements DataSource<PersonaEdm> {

    protected static final Logger LOG = LoggerFactory.getLogger(PersonaDataSource.class);
    private static final String ENTITY_SET_NAME = "Personas";
    
    @Autowired private PersonaRepository personaRepository;
    
    @Override
    public String isSuitableFor() {
        return ENTITY_SET_NAME;
    }

    @Override
    public PersonaEdm create(PersonaEdm entity) throws ODataApplicationException {
        
        if(entity instanceof PersonaEdm) {
            LOG.debug("Endidad PersonaEdm: {}", entity);
            return entity;
        }

        throw new ODataApplicationException(
                "LA ENTIDAD NO ES DEL TIPO PersonEdm", 
                HttpStatusCode.BAD_REQUEST.getStatusCode(), 
                Locale.ENGLISH);
    }

    @Override
    public PersonaEdm update(Map<String, UriParameter> keyPredicateMap, PersonaEdm entity,
            List<String> propertiesInJSON, boolean isPut) throws ODataApplicationException {

        throw new ODataApplicationException(
                "NO IMPLEMENTADO", 
                HttpStatusCode.NOT_IMPLEMENTED.getStatusCode(), 
                Locale.ENGLISH);
    }

    @Override
    public PersonaEdm delete(Map<String, UriParameter> keyPredicateMap)
            throws ODataApplicationException {
        
        throw new ODataApplicationException(
                "NO IMPLEMENTADO", 
                HttpStatusCode.NOT_IMPLEMENTED.getStatusCode(), 
                Locale.ENGLISH);
    }

    @Override
    public Object readFromKey(Map<String, UriParameter> keyPredicateMap, ExpandOption expandOption,
            SelectOption selectOption, Object superentity) throws ODataApplicationException {
        
        Long personaID = Long.valueOf( keyPredicateMap.get("Id").getText() );
        
        PersonaEntity personaEntity = personaRepository.findById(personaID).orElseThrow(
                () -> new ODataApplicationException(
                        String.format("No se encuentra una persona con ID %s", personaID), 
                        HttpStatusCode.NOT_FOUND.getStatusCode(), 
                        Locale.ENGLISH));
        
        return new PersonaEdm(personaEntity);
    }

    @Override
    public Iterable<?> readAll(QueryOptions queryOptions, Object parentEntity) throws ODataApplicationException {

        QuerydslQuery query = new QuerydslQueryBuilder()
            .setClazz(PersonaEdm.class)
            .setQueryOptions(queryOptions)
            .build();
    
        LOG.debug("QuerydslQuery: {}", query);
        
        List<PersonaEntity> personaEntities = QuerydslQuery.execute(personaRepository, query);
        List<PersonaEdm> personaEdms = personaEntities.stream()
            .map(entity -> new PersonaEdm(entity))
            .collect(Collectors.toList());
        
        return personaEdms;
    }
}
