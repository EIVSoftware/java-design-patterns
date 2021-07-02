package com.eiv.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SucursalEntity {

    private Long id;

    private String nombre;

    private String abreviatura;

    private String calle;

    private String calleNumero;

}
