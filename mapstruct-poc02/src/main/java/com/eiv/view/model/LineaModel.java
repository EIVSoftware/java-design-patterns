package com.eiv.view.model;

import com.eiv.data.enums.MonedaCodigoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class LineaModel {

    private Long id;

    private String nombre;

    private MonedaCodigoEnum moneda;

}
