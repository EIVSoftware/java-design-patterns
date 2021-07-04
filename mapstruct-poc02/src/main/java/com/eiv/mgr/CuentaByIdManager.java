package com.eiv.mgr;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.eiv.das.CuentaVistaAcuerdoDas;
import com.eiv.das.CuentaVistaDas;
import com.eiv.das.CuentaVistaSaldoDas;
import com.eiv.data.model.CuentaVistaAcuerdoEntity;
import com.eiv.data.model.CuentaVistaEntity;
import com.eiv.data.model.CuentaVistaSaldoEntity;
import com.eiv.data.model.QCuentaVistaAcuerdoEntity;
import com.eiv.data.model.QCuentaVistaEntity;
import com.eiv.data.model.QCuentaVistaSaldoEntity;
import com.eiv.input.CuentaId;
import com.eiv.task.CuentaAcuerdoFindAllTask;
import com.eiv.task.CuentaFindOneTask;
import com.eiv.task.CuentaSaldoFindOneTask;
import com.eiv.task.TaskRunner;
import com.eiv.view.mapper.CuentaMapper;
import com.eiv.view.model.CuentaModel;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CuentaByIdManager implements Manager<CuentaModel> {

    private final CuentaVistaDas cuentaVistaDas;
    private final CuentaVistaSaldoDas cuentaVistaSaldoDas;
    private final CuentaVistaAcuerdoDas cuentaVistaAcuerdoDas;

    @Value("#{T(java.time.LocalDate).parse('${eivfinanciero.sistema.fecha}')}")
    private LocalDate fechaSistema;

    private final CuentaMapper cuentaMapper;

    private CuentaId cuentaId;

    public CuentaByIdManager setCuentaId(CuentaId cuentaId) {
        this.cuentaId = cuentaId;
        return this;
    }

    @Override
    public CuentaModel execute() {

        CuentaFindOneTask cuentaTask = CuentaFindOneTask.builder()
                .cuentaVistaDas(cuentaVistaDas)
                .build()
                .setQueryCallback(cuentaPredicate());
        CuentaVistaEntity cuenta =
                new TaskRunner<Optional<CuentaVistaEntity>, CuentaFindOneTask>()
                .given(cuentaTask)
                .run()
                .orElseThrow(() -> new RuntimeException("cuenta no encontrada"));

        CuentaSaldoFindOneTask cuentaSaldoTask = CuentaSaldoFindOneTask.builder()
                .cuentaVistaSaldoDas(cuentaVistaSaldoDas)
                .build()
                .setQueryCallback(cuentaSaldoPredicate(cuenta));
        CuentaVistaSaldoEntity saldo =
                new TaskRunner<Optional<CuentaVistaSaldoEntity>, CuentaSaldoFindOneTask>()
                .given(cuentaSaldoTask)
                .run()
                .orElseThrow(() -> new RuntimeException("saldo no encontrado"));

        CuentaAcuerdoFindAllTask cuentaAcuerdoTask = CuentaAcuerdoFindAllTask.builder()
                .cuentaVistaAcuerdoDas(cuentaVistaAcuerdoDas)
                .build()
                .setQueryCallback(cuentaAcuerdoPredicate(cuenta))
                .setPageable(Pageable.unpaged());
        List<CuentaVistaAcuerdoEntity> acuerdos =
                new TaskRunner<Page<CuentaVistaAcuerdoEntity>, CuentaAcuerdoFindAllTask>()
                .given(cuentaAcuerdoTask)
                .run()
                .getContent();

        return cuentaMapper.toFullModel(cuenta, saldo, acuerdos);
    }

    private Function<QCuentaVistaEntity, Predicate> cuentaPredicate() {

        return q -> {
            BooleanBuilder builder = new BooleanBuilder();
            builder.and(q.servicio.sucursal.id.eq(cuentaId.getSucursalId()));
            builder.and(q.servicio.linea.id.eq(cuentaId.getLineaId()));
            builder.and(q.servicio.id.eq(cuentaId.getServicioId()));
            return builder;
        };
    }

    private Function<QCuentaVistaSaldoEntity, Predicate> cuentaSaldoPredicate(
            CuentaVistaEntity cuenta) {

        return q -> {
            BooleanBuilder builder = new BooleanBuilder();
            builder.and(q.servicio.eq(cuenta.getServicio()));
            builder.and(q.fecha.eq(fechaSistema));
            return builder;
        };
    }

    private Function<QCuentaVistaAcuerdoEntity, Predicate> cuentaAcuerdoPredicate(
            CuentaVistaEntity cuenta) {

        return q -> {
            BooleanBuilder builder = new BooleanBuilder();
            builder.and(q.servicio.eq(cuenta.getServicio()));
            return builder;
        };
    }

}
