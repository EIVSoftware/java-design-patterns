package com.eiv.view.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eiv.data.model.LineaEntity;
import com.eiv.view.mapper.qualifiers.SummaryModel;
import com.eiv.view.model.LineaModel;

@Mapper(componentModel = "spring")
public interface LineaMapper {

    LineaModel toFullModel(LineaEntity entity);

    @SummaryModel
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    LineaModel toSummaryModel(LineaEntity entity);

}
