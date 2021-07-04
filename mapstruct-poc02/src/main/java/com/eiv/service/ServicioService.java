package com.eiv.service;

import org.springframework.stereotype.Service;

import com.eiv.input.ServicioId;
import com.eiv.mgr.ServicioByIdManager;
import com.eiv.view.model.ServicioModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioService {

    private final ServicioByIdManager servicioByIdMgr;

    public ServicioModel findById(ServicioId servicioId) {

        return servicioByIdMgr.setServicioId(servicioId).execute();
    }

}
