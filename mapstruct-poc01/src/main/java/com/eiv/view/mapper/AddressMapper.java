package com.eiv.view.mapper;

import com.eiv.data.model.AddressEntity;
import com.eiv.view.model.AddressModel;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    
    AddressMapper INSTANCE = Mappers.getMapper( AddressMapper.class ); 

    AddressModel fromAddressEntity(AddressEntity addressEntity);

}
