package com.eiv.data.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.eiv.data.enums.OperatoriaEnum;

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
@Table(name = "lineas")
public class LineaEntity {

    @EmbeddedId
    @ToString.Include
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private LineaPkEntity pk;

    @Column(name = "operatoria", nullable = false, insertable = false, updatable = false)
    private OperatoriaEnum operatoria;

    @Column(name = "linea",  nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "concepto", length = 40, nullable = false)
    @ToString.Include
    private String nombre;

    @Column(name = "concepto_red", length = 8, nullable = false)
    private String abreviatura;

}
