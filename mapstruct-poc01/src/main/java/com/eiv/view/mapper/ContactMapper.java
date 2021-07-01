package com.eiv.view.mapper;

import com.eiv.data.model.AddressEntity;
import com.eiv.data.model.PersonEntity;
import com.eiv.view.model.ContactModel;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class})
public interface ContactMapper {
    
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mapping(target = "mainAddress", ignore = true)
    @Mapping(target = "altAddresses", ignore = true)
    ContactModel fromPersonaEntity(PersonEntity personEntity);

    @Mapping(target = ".", source = "addressEntity.person")
    @Mapping(target = "mainAddress", source = "addressEntity")
    @Mapping(target = "altAddresses", ignore = true)
    ContactModel fromAddressEntity(AddressEntity addressEntity);
    
    @Mapping(target = "mainAddress", source = "addressEntity")
    @Mapping(target = "altAddresses", source = "addressEntities")
    @Mapping(target = "names", source = "addressEntity.person.names")
    @Mapping(target = "birthDate", source = "addressEntity.person.birthDate")
    @Mapping(target = "gender", source = "addressEntity.person.gender")
    @Mapping(target = "id", source = "addressEntity.person.id")
    ContactModel fromAddressesEntity(AddressEntity addressEntity,
            List<AddressEntity> addressEntities);

}
