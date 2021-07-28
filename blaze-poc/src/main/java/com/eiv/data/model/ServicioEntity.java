package com.eiv.data.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eiv.data.enums.OperatoriaEnum;
import com.eiv.data.enums.ServicioEstadoEnum;

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
@Table(name = "maestros_oper")
public class ServicioEntity {

    @EmbeddedId
    @ToString.Include
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private ServicioPkEntity pk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal", referencedColumnName = "sucursal", nullable = false,
            insertable = false, updatable = false)
    private SucursalEntity sucursal;

    @Column(name = "operatoria", nullable = false, insertable = false, updatable = false)
    private OperatoriaEnum operatoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "operatoria", referencedColumnName = "operatoria",
                    nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "linea", referencedColumnName = "linea",
                    nullable = false, insertable = false, updatable = false)
    })
    private LineaEntity linea;

    @Column(name = "nro_servicio", nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "estado", nullable = false)
    private ServicioEstadoEnum estado;

}
