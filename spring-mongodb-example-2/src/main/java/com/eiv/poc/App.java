package com.eiv.poc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.eiv.poc.docs.DireccionDoc;
import com.eiv.poc.docs.PersonaDoc;
import com.eiv.poc.docs.QPersonaDoc;
import com.eiv.poc.repositories.PersonaRepository;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    private PersonaRepository personaRepository;
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
    
        // limpia colecciones
        
        mongoTemplate.dropCollection(PersonaDoc.class);
        mongoTemplate.dropCollection(DireccionDoc.class);
        
        // crea una persona con dirección y la inserta en la base de datos
        
        DireccionDoc direccion = new DireccionDoc();
        direccion.setCalle("Sarmiento");
        direccion.setNumero("756");
        
        PersonaDoc persona = new PersonaDoc();
        persona.setNombre("Juan Perez");
        persona.setDireccion(direccion);
        persona = mongoTemplate.insert(persona);
        System.out.println(String.format(
                "Se guardó la persona con dirección embebida: %s", persona));
        
        // consulta la persona mediante método del repositorio

        String nombre = "Juan Perez";
        List<PersonaDoc> resultado1 = personaRepository.findByNombre(nombre);
        System.out.println(String.format("Busqueda por nombre <%s> usando repositorio", nombre));
        System.out.println(String.format("Cantidad de resultados: %d", resultado1.size()));
        System.out.println(String.format("Resultados:"));
        resultado1.forEach(System.out::println);
        
        // consulta por criterio particular
        
        Query query = new Query();
        query.addCriteria(Criteria.where("nombre").is(nombre));
        List<PersonaDoc> resultado2 = mongoTemplate.find(query, PersonaDoc.class);
        System.out.println(String.format("Busqueda por nombre <%s> usando criterios", nombre));
        System.out.println(String.format("Cantidad de resultados: %d", resultado2.size()));
        System.out.println(String.format("Resultados:"));
        resultado2.forEach(System.out::println);
        
        // consulta con querydsl
        
        QPersonaDoc q = QPersonaDoc.personaDoc;
        List<PersonaDoc> resultado3 = (List<PersonaDoc>) personaRepository.findAll(
                q.nombre.eq("Juan Perez"));
        System.out.println(String.format("Busqueda por nombre <%s> usando querydsl", nombre));
        System.out.println(String.format("Cantidad de resultados: %d", resultado3.size()));
        System.out.println(String.format("Resultados:"));
        resultado3.forEach(System.out::println);

    }
    
}
