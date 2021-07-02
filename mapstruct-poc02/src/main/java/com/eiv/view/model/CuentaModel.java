package com.eiv.view.model;

import java.math.BigDecimal;

import com.eiv.data.enums.MonedaCodigoEnum;
import com.eiv.data.enums.ServicioEstadoEnum;
import com.eiv.input.CuentaId;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
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
