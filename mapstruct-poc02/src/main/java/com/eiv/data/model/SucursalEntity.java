package com.eiv.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
public class SucursalEntity {

    @Id
    private Long id;

    private String nombre;

    private String abreviatura;

    private String calle;

    private String calleNumero;

}
