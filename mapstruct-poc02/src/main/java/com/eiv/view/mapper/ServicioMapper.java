package com.eiv.view.mapper;

import org.mapstruct.Mapper;

import com.eiv.data.model.ServicioEntity;
import com.eiv.view.model.ServicioModel;

@Mapper(componentModel = "spring")
public interface ServicioMapper {

    ServicioModel toFullModel(ServicioEntity entity);

}
