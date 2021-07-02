package com.eiv.view.model;

import java.math.BigDecimal;

import com.eiv.data.enums.MonedaCodigoEnum;
import com.eiv.data.enums.ServicioEstadoEnum;
import com.eiv.input.CuentaId;

import lombok.Data;

@Data
public class CuentaModel implements CuentaId {

    private Long sucursalId;

    private Long lineaId;

    private Long servicioId;

    private SucursalModel sucursal;

    private LineaModel linea;

    private MonedaCodigoEnum moneda;

    private BigDecimal saldo;

    private ServicioEstadoEnum estado;

    private BigDecimal acuerdo;

}
