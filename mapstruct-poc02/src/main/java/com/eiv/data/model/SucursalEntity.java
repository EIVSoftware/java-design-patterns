package com.eiv.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sucursal")
public class SucursalEntity {

    @Id
    @Column(name = "sucursal_id")
    private Long id;

    private String nombre;

    private String abreviatura;

    private String calle;

    private String calleNumero;

}
