package com.eiv.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.eiv.data.enums.OperatoriaEnum;

import lombok.AccessLevel;
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
public class LineaPkEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "operatoria", nullable = false)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Integer operatoriaId;

    @Column(name = "linea", nullable = false)
    private Long lineaId;

    public LineaPkEntity(OperatoriaEnum operatoria, Long lineaId) {
        setOperatoria(operatoria);
        this.lineaId = lineaId;
    }

    public OperatoriaEnum getOperatoria() {
        return OperatoriaEnum.of(operatoriaId);
    }

    public void setOperatoria(OperatoriaEnum operatoria) {
        this.operatoriaId = operatoria == null ? null : operatoria.getDbValue();
    }

}
