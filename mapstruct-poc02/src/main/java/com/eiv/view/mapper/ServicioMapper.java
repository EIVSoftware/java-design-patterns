package com.eiv.view.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.eiv.data.model.ServicioEntity;
import com.eiv.view.model.ServicioModel;

@Mapper
public interface ServicioMapper {

    ServicioMapper INSTANCE = Mappers.getMapper(ServicioMapper.class);

    ServicioModel toFullModel(ServicioEntity entity);

}
