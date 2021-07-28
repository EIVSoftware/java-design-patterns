package com.eiv.data.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.blazebit.persistence.CTE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@CTE
@Entity
public class CuentaMovSaldoCte {

    @Id
    private CuentaMovPkEntity pk;

    /**
     * Saldo acumulado desde el final del día hasta este movimiento.
     */
    private BigDecimal acumulado;

}
