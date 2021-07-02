package com.eiv.view.model;

import com.eiv.data.enums.OperatoriaEnum;
import com.eiv.data.enums.ServicioEstadoEnum;

import lombok.Data;

@Data
public class ServicioModel {

    private SucursalModel sucursal;

    private OperatoriaEnum operatoria;

    private LineaModel linea;

    private Long id;

    private ServicioEstadoEnum estado;

}
