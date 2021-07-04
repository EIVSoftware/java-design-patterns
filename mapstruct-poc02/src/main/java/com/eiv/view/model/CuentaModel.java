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

    private SucursalModel sucursal;

    private LineaModel linea;

    private ServicioModel servicio;

    private MonedaCodigoEnum moneda;

    private BigDecimal saldo;

    private ServicioEstadoEnum estado;

    private BigDecimal acuerdo;

    @Override
    public Long getSucursalId() {
        return sucursal.getId();
    }

    @Override
    public Long getLineaId() {
        return linea.getId();
    }

    @Override
    public Long getServicioId() {
        return servicio.getId();
    }

}
