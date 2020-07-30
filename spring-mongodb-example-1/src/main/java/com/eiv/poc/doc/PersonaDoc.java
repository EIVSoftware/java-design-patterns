package com.eiv.poc.doc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "personas")
@QueryEntity
public class PersonaDoc {
    
    @Id
    private String id;
    
    private String nombre;
    
    private DireccionObj direccionObj;
    
    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class DireccionObj {
        
        private String calle;
        
        private String numero;
        
    }
    
    private DireccionDoc direccionDoc;

}
