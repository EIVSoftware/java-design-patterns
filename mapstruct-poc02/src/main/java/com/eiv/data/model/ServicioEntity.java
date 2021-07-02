package com.eiv.data.model;

import com.eiv.data.enums.OperatoriaEnum;
import com.eiv.data.enums.ServicioEstadoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ServicioEntity {

    private SucursalEntity sucursal;

    private OperatoriaEnum operatoria;

    private LineaEntity linea;

    private Long id;

    private ServicioEstadoEnum estado;

}
