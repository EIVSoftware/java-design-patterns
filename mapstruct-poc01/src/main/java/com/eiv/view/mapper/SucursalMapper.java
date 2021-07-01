package com.eiv.view.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.eiv.data.model.SucursalEntity;
import com.eiv.view.model.KeyValuePairModel;

@Mapper
public interface SucursalMapper {

    SucursalMapper INSTANCE = Mappers.getMapper(SucursalMapper.class);

    @Mapping(target = "value", source = "name")
    KeyValuePairModel toKeyValuePair(SucursalEntity entity);

}
