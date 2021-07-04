package com.eiv.data.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eiv.data.enums.OperatoriaEnum;
import com.eiv.data.enums.ServicioEstadoEnum;
import com.eiv.data.pk.ServicioPkEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servicio")
public class ServicioEntity {

    @EmbeddedId
    private ServicioPkEntity pk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "sucursal_id",
            insertable = false, updatable = false)
    private SucursalEntity sucursal;

    @Enumerated(EnumType.STRING)
    @Column(name = "operatoria", insertable = false, updatable = false)
    private OperatoriaEnum operatoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "operatoria", referencedColumnName = "operatoria",
                    insertable = false, updatable = false),
            @JoinColumn(name = "linea_id", referencedColumnName = "linea_id",
                    insertable = false, updatable = false)})
    private LineaEntity linea;

    @Column(name = "servicio_id", insertable = false, updatable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ServicioEstadoEnum estado;

}
