package com.eiv.data.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuenta_vista_saldo")
public class CuentaVistaSaldoEntity {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "sucursal_id", referencedColumnName = "sucursal_id"),
            @JoinColumn(name = "operatoria", referencedColumnName = "operatoria"),
            @JoinColumn(name = "linea_id", referencedColumnName = "linea_id"),
            @JoinColumn(name = "servicio_id", referencedColumnName = "servicio_id")})
    private ServicioEntity servicio;

    private LocalDate fecha;

    private BigDecimal saldo;

}
