package com.eiv.view.mapper;

import com.eiv.data.model.AddressEntity;
import com.eiv.data.model.PersonEntity;
import com.eiv.view.model.ContactModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class})
public interface ContactMapper {
    
    ContactMapper INSTANCE = Mappers.getMapper( ContactMapper.class ); 

    ContactModel fromPersonaEntity(PersonEntity personEntity);

    @Mapping(target = ".", source = "addressEntity.person")
    @Mapping(target = "mainAddress", source = "addressEntity")
    ContactModel fromAddressEntity(AddressEntity addressEntity);

}
