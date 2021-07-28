package com.eiv.data.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ctacte_maesal")
public class CuentaSaldoEntity {

    @Id
    @Column(name = "id")
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "sucursal", referencedColumnName = "sucursal",
                    nullable = false),
            @JoinColumn(name = "operatoria", referencedColumnName = "operatoria",
                    nullable = false),
            @JoinColumn(name = "linea", referencedColumnName = "linea",
                    nullable = false),
            @JoinColumn(name = "nro_servicio", referencedColumnName = "nro_servicio",
                    nullable = false)
    })
    private ServicioEntity servicio;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "saldo", precision = 13, scale = 2)
    private BigDecimal saldo;
}
