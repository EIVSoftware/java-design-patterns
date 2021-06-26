package com.eiv.data.model;

import lombok.Data;

@Data
public class AddressEntity {
    
    private Long id;

    private PersonEntity person;

    private String street;

    private String number;

    private Boolean mainAddress;

}
