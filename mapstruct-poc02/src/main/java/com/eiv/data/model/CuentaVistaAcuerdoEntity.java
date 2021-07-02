package com.eiv.data.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CuentaVistaAcuerdoEntity {

    private BigDecimal importe;

}
