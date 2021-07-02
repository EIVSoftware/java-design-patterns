package com.eiv.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.eiv.data.enums.OperatoriaEnum;
import com.eiv.data.enums.ServicioEstadoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
public class ServicioEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private SucursalEntity sucursal;

    private OperatoriaEnum operatoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private LineaEntity linea;

    @Id
    private Long id;

    private ServicioEstadoEnum estado;

}
