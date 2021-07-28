package com.eiv.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sucursal")
public class SucursalEntity {

    @Id
    @Column(name = "sucursal")
    private Long id;

    @Column(name = "descripcion")
    private String nombre;

    @Column(name = "desc_reduc")
    private String abreviatura;

    @Column(name = "calle")
    private String calle;

    @Column(name = "calle_nro")
    private String calleNumero;

}
