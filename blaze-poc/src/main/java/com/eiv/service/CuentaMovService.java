package com.eiv.service;

import static com.blazebit.persistence.querydsl.JPQLNextExpressions.bind;
import static com.blazebit.persistence.querydsl.JPQLNextExpressions.select;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.eiv.data.enums.OperatoriaEnum;
import com.eiv.data.model.CuentaMovEntity;
import com.eiv.data.model.QCuentaMovEntity;
import com.eiv.data.model.QCuentaMovSaldoCte;
import com.eiv.data.model.QCuentaSaldoEntity;
import com.eiv.input.CuentaId;
import com.eiv.view.mapper.CuentaMovMapper;
import com.eiv.view.model.CuentaMovModel;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.SimpleExpression;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaMovService {

    private final EntityManager em;
    private final CriteriaBuilderFactory cbf;

    private final CuentaMovMapper cuentaMovMapper;

    public List<CuentaMovModel> findByCuentaId(CuentaId cuentaId) {

        QCuentaMovEntity m1 = new QCuentaMovEntity("m1");
        QCuentaMovEntity m2 = new QCuentaMovEntity("m2");

        QCuentaMovEntity m = new QCuentaMovEntity("m");
        QCuentaSaldoEntity s = QCuentaSaldoEntity.cuentaSaldoEntity;

        QCuentaMovSaldoCte sub1 = new QCuentaMovSaldoCte("sub1");
        QCuentaMovSaldoCte sub2 = new QCuentaMovSaldoCte("sub2");

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(m.servicio.sucursal.id.eq(cuentaId.getSucursalId()));
        builder.and(m.servicio.operatoria.eq(OperatoriaEnum.CUENTA_VISTA));
        builder.and(m.servicio.linea.id.eq(cuentaId.getLineaId()));
        builder.and(m.servicio.id.eq(cuentaId.getServicioId()));

        SimpleExpression<BigDecimal> saldoExp = s.saldo.subtract(new CaseBuilder()
                .when(sub1.acumulado.isNull())
                    .then(Expressions.constant(new BigDecimal("0.00")))
                .otherwise(sub1.acumulado));

        List<Tuple> result = new BlazeJPAQuery<>(em, cbf)
                .with(sub2, select(
                        bind(sub2.pk, m1.pk),
                        bind(sub2.acumulado,
                                m2.importeCredito.subtract(m2.importeDebito).sum()))
                        .from(m1)
                        .leftJoin(m2)
                        .on(m1.pk.sucursalId.eq(m2.pk.sucursalId)
                                .and(m1.pk.lineaId.eq(m2.pk.lineaId))
                                .and(m1.pk.servicioId.eq(m2.pk.servicioId))
                                .and(m1.pk.fechaContable.eq(m2.fechaContable))
                                .and(m1.pk.id.lt(m2.id)))
                        .groupBy(m1.pk))
                .select(m, saldoExp.as("saldo"))
                .from(m)
                .innerJoin(sub2, sub1)
                    .on(sub1.pk.eq(m.pk))
                .leftJoin(s)
                    .on(s.servicio.eq(m.servicio)
                    .and(s.fecha.eq(m.fechaContable)))
                .where(builder)
                .orderBy(m.fechaContable.asc(), m.id.asc())
                .fetch();

        /* Imprime importe y saldo
        for (Tuple tuple : result) {
            CuentaMovEntity mov = tuple.get(m);
            BigDecimal saldo = tuple.get(Expressions.numberPath(BigDecimal.class, "saldo"));
            System.out.println(String.format("%s : %s",
                    mov.getImporteCredito().subtract(mov.getImporteDebito()).toString(),
                    saldo));
        }
        */

        return result.stream().map(t -> {
            CuentaMovEntity mov = t.get(m);
            BigDecimal saldo = t.get(Expressions.numberPath(BigDecimal.class, "saldo"));
            return cuentaMovMapper.toFullModel(mov, saldo);
        }).collect(Collectors.toList());
    }

}
