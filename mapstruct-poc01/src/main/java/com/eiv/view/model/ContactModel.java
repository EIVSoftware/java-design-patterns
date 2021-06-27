package com.eiv.view.model;

import java.time.LocalDate;
import java.util.List;

import com.eiv.data.model.GenderEnum;

import lombok.Data;

@Data
public class ContactModel {
    
    private Long id;

    private String names;

    private LocalDate birthDate;

    private GenderEnum gender;
    
    private AddressModel mainAddress;
    
    private List<AddressModel> altAddresses;
    
}
