package com.eiv.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.eiv.data.enums.MonedaCodigoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
public class LineaEntity {

    @Id
    private Long id;

    private String nombre;

    private MonedaCodigoEnum moneda;

}
