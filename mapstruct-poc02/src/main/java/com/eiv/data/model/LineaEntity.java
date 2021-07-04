package com.eiv.data.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.eiv.data.enums.MonedaCodigoEnum;
import com.eiv.data.enums.OperatoriaEnum;
import com.eiv.data.pk.LineaPkEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "linea")
public class LineaEntity {

    @EmbeddedId
    private LineaPkEntity pk;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private OperatoriaEnum operatoria;

    @Column(name = "linea_id", insertable = false, updatable = false)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private MonedaCodigoEnum moneda;

}
