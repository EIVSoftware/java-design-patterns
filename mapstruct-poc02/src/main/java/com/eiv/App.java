package com.eiv;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.eiv.data.enums.MonedaCodigoEnum;
import com.eiv.data.enums.OperatoriaEnum;
import com.eiv.data.enums.ServicioEstadoEnum;
import com.eiv.data.model.CuentaVistaAcuerdoEntity;
import com.eiv.data.model.CuentaVistaEntity;
import com.eiv.data.model.CuentaVistaSaldoEntity;
import com.eiv.data.model.LineaEntity;
import com.eiv.data.model.ServicioEntity;
import com.eiv.data.model.SucursalEntity;
import com.eiv.view.mapper.CuentaMapper;
import com.eiv.view.mapper.ServicioMapper;
import com.eiv.view.mapper.SucursalMapper;
import com.eiv.view.model.CuentaModel;
import com.eiv.view.model.ServicioModel;
import com.eiv.view.model.SucursalModel;

public class App {

    public static void main(String[] args) {

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
        CuentaVistaSaldoEntity saldo = CuentaVistaSaldoEntity.builder()
                .saldo(new BigDecimal("1234.567"))
                .build();
        List<CuentaVistaAcuerdoEntity> acuerdos = Arrays.asList(
                CuentaVistaAcuerdoEntity.builder()
                    .importe(new BigDecimal("00.01"))
                    .build(),
                CuentaVistaAcuerdoEntity.builder()
                    .importe(new BigDecimal("00.10"))
                    .build(),
                CuentaVistaAcuerdoEntity.builder()
                    .importe(new BigDecimal("01.00"))
                    .build(),
                CuentaVistaAcuerdoEntity.builder()
                    .importe(new BigDecimal("10.00"))
                    .build());

        SucursalModel sucursalFullModel = SucursalMapper.INSTANCE.toFullModel(sucursal);
        SucursalModel sucursalSummaryModel = SucursalMapper.INSTANCE.toSummaryModel(sucursal);

        CuentaModel cuentaFullModel = CuentaMapper.INSTANCE.toFullModel(cuenta, saldo, acuerdos);

        ServicioModel servicioFullModel = ServicioMapper.INSTANCE.toFullModel(servicio);

        System.out.println("ah!");
        //TODO

    }
}
