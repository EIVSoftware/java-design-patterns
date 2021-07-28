package com.eiv.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.eiv.data.enums.OperatoriaEnum;

import lombok.AccessLevel;
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
public class ServicioPkEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "sucursal", nullable = false)
    private Long sucursalId;

    @Column(name = "operatoria", nullable = false)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Integer operatoriaId;

    @Column(name = "linea", nullable = false)
    private Long lineaId;

    @Column(name = "nro_servicio", nullable = false)
    private Long id;

    public ServicioPkEntity(Long sucursalId, OperatoriaEnum operatoria,
                Long lineaId, Long id) {
        super();
        this.sucursalId = sucursalId;
        setOperatoria(operatoria);
        this.lineaId = lineaId;
        this.id = id;
    }

    public OperatoriaEnum getOperatoria() {
        return operatoriaId == null ? null : OperatoriaEnum.of(operatoriaId);
    }

    public void setOperatoria(OperatoriaEnum operatoria) {
        this.operatoriaId = operatoria == null ? null : operatoria.getDbValue();
    }

}
