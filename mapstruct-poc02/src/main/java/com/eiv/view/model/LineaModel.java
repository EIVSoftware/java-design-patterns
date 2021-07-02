package com.eiv.view.model;

import com.eiv.data.enums.MonedaCodigoEnum;

import lombok.Data;

@Data
public class LineaModel {

    private Long id;

    private String nombre;

    private MonedaCodigoEnum moneda;

}
