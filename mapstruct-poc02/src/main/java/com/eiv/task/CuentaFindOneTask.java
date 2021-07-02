package com.eiv.task;

import java.util.Optional;
import java.util.function.Function;

import com.eiv.das.CuentaVistaDas;
import com.eiv.data.model.CuentaVistaEntity;
import com.eiv.data.model.QCuentaVistaEntity;
import com.querydsl.core.types.Predicate;

import lombok.Builder;

public class CuentaFindOneTask implements Task<Optional<CuentaVistaEntity>> {

    private CuentaVistaDas cuentaVistaDas;

    private Function<QCuentaVistaEntity, Predicate> queryCallback;

    @Builder
    public CuentaFindOneTask(CuentaVistaDas cuentaVistaDas) {
        this.cuentaVistaDas = cuentaVistaDas;
    }

    public CuentaFindOneTask setQueryCallback(
            Function<QCuentaVistaEntity, Predicate> queryCallback) {
        this.queryCallback = queryCallback;
        return this;
    }

    @Override
    public Optional<CuentaVistaEntity> run() {
        return cuentaVistaDas.findOne(queryCallback);
    }

}
