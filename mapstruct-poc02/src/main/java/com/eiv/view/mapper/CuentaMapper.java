package com.eiv.view.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eiv.data.model.CuentaVistaAcuerdoEntity;
import com.eiv.data.model.CuentaVistaEntity;
import com.eiv.data.model.CuentaVistaSaldoEntity;
import com.eiv.view.mapper.qualifiers.SummaryModel;
import com.eiv.view.model.CuentaModel;

@Mapper(
        uses = {SucursalMapper.class, LineaMapper.class, ServicioMapper.class},
        componentModel = "spring")
public interface CuentaMapper {

    @Mapping(target = "sucursal", source = "cuenta.servicio.sucursal", qualifiedBy = SummaryModel.class)
    @Mapping(target = "linea", source = "cuenta.servicio.linea", qualifiedBy = SummaryModel.class)
    @Mapping(target = "servicio", source = "cuenta.servicio", qualifiedBy = SummaryModel.class)
    @Mapping(target = "moneda", source = "cuenta.servicio.linea.moneda")
    @Mapping(target = "estado", source = "cuenta.servicio.estado")
    @Mapping(target = "saldo", source = "saldo.saldo")
    @Mapping(target = "acuerdo", source = "acuerdos")
    CuentaModel toFullModel(
            CuentaVistaEntity cuenta,
            CuentaVistaSaldoEntity saldo,
            List<CuentaVistaAcuerdoEntity> acuerdos);

    default BigDecimal acuerdosToBigDecimal(List<CuentaVistaAcuerdoEntity> acuerdos) {
        return acuerdos.stream()
                .reduce(BigDecimal.ZERO, (d, a) -> d.add(a.getImporte()),
                        BigDecimal::add);
    }

}
