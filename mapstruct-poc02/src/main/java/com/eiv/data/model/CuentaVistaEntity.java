package com.eiv.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CuentaVistaEntity {

    private SucursalEntity sucursal;

    private LineaEntity linea;

    private ServicioEntity servicio;

    private Long id;

}
