package com.eiv.task;

import java.util.function.Function;

import org.springframework.data.domain.Page;

import com.eiv.das.CuentaVistaAcuerdoDas;
import com.eiv.data.model.CuentaVistaAcuerdoEntity;
import com.eiv.data.model.QCuentaVistaAcuerdoEntity;
import com.querydsl.core.types.Predicate;

import lombok.Builder;

public class CuentaAcuerdoFindAllTask implements Task<Page<CuentaVistaAcuerdoEntity>> {

    private CuentaVistaAcuerdoDas cuentaVistaAcuerdoDas;

    private Function<QCuentaVistaAcuerdoEntity, Predicate> queryCallback;

    @Builder
    public CuentaAcuerdoFindAllTask(CuentaVistaAcuerdoDas cuentaVistaAcuerdoDas) {
        this.cuentaVistaAcuerdoDas = cuentaVistaAcuerdoDas;
    }

    public CuentaAcuerdoFindAllTask setQueryCallback(
            Function<QCuentaVistaAcuerdoEntity, Predicate> queryCallback) {
        this.queryCallback = queryCallback;
        return this;
    }

    @Override
    public Page<CuentaVistaAcuerdoEntity> run() {
        return cuentaVistaAcuerdoDas.findAll(queryCallback);
    }

}
