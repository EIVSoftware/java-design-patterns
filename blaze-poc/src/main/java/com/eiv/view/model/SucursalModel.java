package com.eiv.view.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SucursalModel {

    private Long id;

    private String nombre;

    private String abreviatura;

    private String calle;

    private String calleNumero;

}
