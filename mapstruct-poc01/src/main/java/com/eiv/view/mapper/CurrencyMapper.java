package com.eiv.view.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.eiv.data.model.CurrencyEntity;
import com.eiv.view.model.KeyValuePairModel;

@Mapper
public interface CurrencyMapper {

    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    @Mapping(target = "id", source = "isoCode")
    @Mapping(target = "value", source = "name")
    KeyValuePairModel toKeyValuePair(CurrencyEntity entity);

}
