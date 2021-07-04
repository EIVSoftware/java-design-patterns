package com.eiv.data.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.eiv.data.enums.OperatoriaEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioPkEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "sucursal_id")
    private Long sucursalId;

    @Enumerated(EnumType.STRING)
    private OperatoriaEnum operatoria;

    @Column(name = "linea_id")
    private Long lineaId;

    @Column(name = "servicio_id")
    private Long servicioId;

}
