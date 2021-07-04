package com.eiv.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.input.CuentaId;
import com.eiv.service.CuentaService;
import com.eiv.view.model.CuentaModel;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cuentas")
public class CuentaCtrl {

    private final CuentaService cuentaService;

    @GetMapping
    private ResponseEntity<CuentaModel> buscarPorId(CuentaId cuentaId) {

        CuentaModel cuenta = cuentaService.findById(cuentaId);
        return ResponseEntity.ok(cuenta);
    }

}
