package com.eiv.view.mapper;

import java.math.BigDecimal;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eiv.data.model.CuentaMovEntity;
import com.eiv.view.mapper.qualifiers.SummaryModel;
import com.eiv.view.model.CuentaMovModel;

@Mapper(componentModel = "spring", uses = SucursalMapper.class)
public interface CuentaMovMapper {

    @Mapping(target = "sucursal", source = "mov.servicio.sucursal",
            qualifiedBy = SummaryModel.class)
    @Mapping(target = "lineaId", source = "mov.servicio.linea.id")
    @Mapping(target = "servicioId", source = "mov.servicio.id")
    @Mapping(target = "operacionCfgId", source = "mov.operacionCfgId")
    @Mapping(target = "importe", source = "mov")
    CuentaMovModel toFullModel(CuentaMovEntity mov, BigDecimal saldo);

    default BigDecimal importe(CuentaMovEntity mov) {
        return mov.getImporteCredito().subtract(mov.getImporteDebito());
    }
}
