package com.eiv.mgr;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.eiv.das.ServicioDas;
import com.eiv.data.model.ServicioEntity;
import com.eiv.data.pk.ServicioPkEntity;
import com.eiv.input.ServicioId;
import com.eiv.task.ServicioByIdTask;
import com.eiv.task.TaskRunner;
import com.eiv.view.mapper.ServicioMapper;
import com.eiv.view.model.ServicioModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServicioByIdManager implements Manager<ServicioModel> {

    private final ServicioDas servicioDas;
    private final ServicioMapper servicioMapper;

    private ServicioId servicioId;

    public ServicioByIdManager setServicioId(ServicioId servicioId) {
        this.servicioId = servicioId;
        return this;
    }

    @Override
    public ServicioModel execute() {

        ServicioByIdTask task = ServicioByIdTask.builder()
                .servicioDas(servicioDas)
                .build()
                .setPk(new ServicioPkEntity(
                        servicioId.getSucursalId(),
                        servicioId.getOperatoria(),
                        servicioId.getLineaId(),
                        servicioId.getServicioId()));
        ServicioEntity servicio = new TaskRunner<Optional<ServicioEntity>, ServicioByIdTask>()
                .given(task)
                .run()
                .orElseThrow(() -> new RuntimeException("servicio no encontrado"));

        return servicioMapper.toFullModel(servicio);
    }

}
