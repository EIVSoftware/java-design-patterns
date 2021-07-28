package com.eiv.ctrl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.input.CuentaId;
import com.eiv.service.CuentaMovService;
import com.eiv.view.model.CuentaMovModel;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cuentas")
public class CuentaCtrl {

    private final CuentaMovService cuentaMovService;

    /**
     * Devuelve todos los movimientos de la cuenta indicada con su saldo.
     * Consultar con: 11-200-31944, 99-203-779
     *
     * @param cuentaId identificador de cuenta
     * @return movimiento con saldo
     */
    @GetMapping(path = "movs")
    private ResponseEntity<List<CuentaMovModel>> buscarPorCuentaId(
            CuentaId cuentaId) {

        List<CuentaMovModel> result = cuentaMovService.findByCuentaId(cuentaId);
        return ResponseEntity.ok(result);
    }

}
