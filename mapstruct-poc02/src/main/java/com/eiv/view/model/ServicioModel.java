package com.eiv.view.model;

import com.eiv.data.enums.OperatoriaEnum;
import com.eiv.data.enums.ServicioEstadoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ServicioModel {

    private SucursalModel sucursal;

    private OperatoriaEnum operatoria;

    private LineaModel linea;

    private Long id;

    private ServicioEstadoEnum estado;

}
