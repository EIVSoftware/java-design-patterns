package com.eiv.view.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eiv.data.model.ServicioEntity;
import com.eiv.view.mapper.qualifiers.SummaryModel;
import com.eiv.view.model.ServicioModel;

@Mapper(
        uses = {SucursalMapper.class, LineaMapper.class},
        componentModel = "spring")
public interface ServicioMapper {

    @Mapping(target = "sucursal", source = "sucursal", qualifiedBy = SummaryModel.class)
    @Mapping(target = "linea", source = "linea", qualifiedBy = SummaryModel.class)
    ServicioModel toFullModel(ServicioEntity servicio);

    @SummaryModel
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "estado", source = "estado")
    ServicioModel toSummaryModel(ServicioEntity servicio);

}
