package com.eiv.data.model;

import com.eiv.data.enums.MonedaCodigoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LineaEntity {

    private Long id;

    private String nombre;

    private MonedaCodigoEnum moneda;

}
