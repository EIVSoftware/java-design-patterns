    package com.eiv.data.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eiv.data.enums.CuentaMovEstadoEnum;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ctacte_movim")
public class CuentaMovEntity {

    @EmbeddedId
    @ToString.Include
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private CuentaMovPkEntity pk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "sucursal", referencedColumnName = "sucursal",
                    insertable = false, updatable = false, nullable = false),
            @JoinColumn(name = "operatoria", referencedColumnName = "operatoria",
                    insertable = false, updatable = false, nullable = false),
            @JoinColumn(name = "linea", referencedColumnName = "linea",
                    insertable = false, updatable = false, nullable = false),
            @JoinColumn(name = "nro_servicio", referencedColumnName = "nro_servicio",
                    insertable = false, updatable = false, nullable = false)
    })
    private ServicioEntity servicio;

    @Column(name = "movimiento", insertable = false, updatable = false, nullable = false)
    private Long operacionCfgId;

    @Column(name = "fecha_contable", insertable = false, updatable = false, nullable = false)
    private LocalDate fechaContable;

    @Column(name = "fecha_proceso", insertable = false, updatable = false, nullable = false)
    private LocalDate fechaProceso;

    @Column(name = "orden", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "importe_debito", precision = 13, scale = 2, nullable = false)
    private BigDecimal importeDebito;

    @Column(name = "importe_credito", precision = 13, scale = 2, nullable = false)
    private BigDecimal importeCredito;

    @Column(name = "estado")
    private CuentaMovEstadoEnum estado;

}
