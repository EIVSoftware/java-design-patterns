package com.eiv.poc.doc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "direcciones")
public class DireccionDoc {
    
    @Id
    private String id;
    
    private String calle;
    
    private String numero;

}
