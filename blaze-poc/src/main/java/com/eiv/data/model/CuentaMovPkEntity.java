package com.eiv.data.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.eiv.data.enums.OperatoriaEnum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CuentaMovPkEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "sucursal")
    private Long sucursalId;

    @Column(name = "operatoria")
    private OperatoriaEnum operatoria;

    @Column(name = "linea")
    private Long lineaId;

    @Column(name = "nro_servicio")
    private Long servicioId;

    @Column(name = "movimiento")
    private Long operacionCfgId;

    @Column(name = "fecha_contable")
    private LocalDate fechaContable;

    @Column(name = "fecha_proceso")
    private LocalDate fechaProceso;

    @Column(name = "orden")
    private Long id;

}
