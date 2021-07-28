package com.eiv.view.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CuentaMovModel {

    private SucursalModel sucursal;

    private Long lineaId;

    private Long servicioId;

    private Long operacionCfgId;

    private LocalDate fechaContable;

    private Long id;

    private BigDecimal importe;

    private BigDecimal saldo;

}
