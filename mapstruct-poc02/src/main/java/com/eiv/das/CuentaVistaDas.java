package com.eiv.das;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.eiv.data.enums.MonedaCodigoEnum;
import com.eiv.data.enums.OperatoriaEnum;
import com.eiv.data.enums.ServicioEstadoEnum;
import com.eiv.data.model.CuentaVistaEntity;
import com.eiv.data.model.LineaEntity;
import com.eiv.data.model.QCuentaVistaEntity;
import com.eiv.data.model.ServicioEntity;
import com.eiv.data.model.SucursalEntity;
import com.querydsl.core.types.Predicate;

@Service
public class CuentaVistaDas {

    public Optional<CuentaVistaEntity> findOne(
            Function<QCuentaVistaEntity, Predicate> queryCallback) {

        SucursalEntity sucursal = SucursalEntity.builder()
                .id(11L)
                .nombre("ROSARIO CENTRO")
                .abreviatura("RCENTRO")
                .calle("SAN LORENZO")
                .calleNumero("1255")
                .build();

        LineaEntity linea = LineaEntity.builder()
                .id(200L)
                .nombre("CUENTA PERS. DE AHORRO COMUN EN DOLARES")
                .moneda(MonedaCodigoEnum.USD)
                .build();

        ServicioEntity servicio = ServicioEntity.builder()
                .sucursal(sucursal)
                .operatoria(OperatoriaEnum.CUENTA)
                .linea(linea)
                .id(12L)
                .estado(ServicioEstadoEnum.ACTIVO)
                .build();

        CuentaVistaEntity cuenta = CuentaVistaEntity.builder()
                .sucursal(sucursal)
                .linea(linea)
                .servicio(servicio)
                .id(0L)
                .build();

        return Optional.of(cuenta);
    }

}
