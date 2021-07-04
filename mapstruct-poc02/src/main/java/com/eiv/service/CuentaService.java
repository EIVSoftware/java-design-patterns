package com.eiv.service;

import org.springframework.stereotype.Service;

import com.eiv.input.CuentaId;
import com.eiv.mgr.CuentaByIdManager;
import com.eiv.view.model.CuentaModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaService {

    private final CuentaByIdManager cuentaFindByIdMgr;

    public CuentaModel findById(CuentaId cuentaId) {

        return cuentaFindByIdMgr.setCuentaId(cuentaId).execute();
    }

}
