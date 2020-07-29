package com.eiv.poc.docs;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document
public class PersonaDoc {
    
    @Id
    private String id;
    
    private String nombre;
    
    @DBRef
    private DireccionDoc direccion;

}
