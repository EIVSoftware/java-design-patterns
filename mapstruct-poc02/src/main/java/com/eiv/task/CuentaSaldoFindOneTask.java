package com.eiv.task;

import java.util.Optional;
import java.util.function.Function;

import com.eiv.das.CuentaVistaSaldoDas;
import com.eiv.data.model.CuentaVistaSaldoEntity;
import com.eiv.data.model.QCuentaVistaSaldoEntity;
import com.querydsl.core.types.Predicate;

import lombok.Builder;

public class CuentaSaldoFindOneTask implements Task<Optional<CuentaVistaSaldoEntity>> {

    private CuentaVistaSaldoDas cuentaVistaSaldoDas;

    private Function<QCuentaVistaSaldoEntity, Predicate> queryCallback;

    @Builder
    public CuentaSaldoFindOneTask(CuentaVistaSaldoDas cuentaVistaSaldoDas) {
        this.cuentaVistaSaldoDas = cuentaVistaSaldoDas;
    }

    public CuentaSaldoFindOneTask setQueryCallback(
            Function<QCuentaVistaSaldoEntity, Predicate> queryCallback) {
        this.queryCallback = queryCallback;
        return this;
    }

    @Override
    public Optional<CuentaVistaSaldoEntity> run() {
        return cuentaVistaSaldoDas.findOne(queryCallback);
    }

}
