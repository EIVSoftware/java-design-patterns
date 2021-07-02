package com.eiv.view.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eiv.data.model.SucursalEntity;
import com.eiv.view.mapper.qualifiers.SummaryModel;
import com.eiv.view.model.SucursalModel;

@Mapper(componentModel = "spring")
public interface SucursalMapper {

    SucursalModel toFullModel(SucursalEntity entity);

    @SummaryModel
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    SucursalModel toSummaryModel(SucursalEntity entity);

}
