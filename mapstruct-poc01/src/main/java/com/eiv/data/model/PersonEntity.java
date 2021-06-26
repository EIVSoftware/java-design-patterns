package com.eiv.data.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PersonEntity {
    
    private Long id;

    private String names;

    private LocalDate birthDate;

    private GenderEnum gender;

}
