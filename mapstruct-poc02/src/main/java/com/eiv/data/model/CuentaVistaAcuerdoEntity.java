package com.eiv.data.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
public class CuentaVistaAcuerdoEntity {

    @Id
    private Long id;

    private BigDecimal importe;

}
