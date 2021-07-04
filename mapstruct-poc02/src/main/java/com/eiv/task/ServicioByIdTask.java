package com.eiv.task;

import java.util.Optional;

import com.eiv.das.ServicioDas;
import com.eiv.data.model.ServicioEntity;
import com.eiv.data.pk.ServicioPkEntity;

import lombok.Builder;

public class ServicioByIdTask implements Task<Optional<ServicioEntity>> {

    private ServicioDas servicioDas;

    private ServicioPkEntity pk;

    @Builder
    public ServicioByIdTask(ServicioDas servicioDas) {
        this.servicioDas = servicioDas;
    }

    public ServicioByIdTask setPk(ServicioPkEntity pk) {
        this.pk = pk;
        return this;
    }

    @Override
    public Optional<ServicioEntity> run() {
        return servicioDas.findById(pk);
    }

}
