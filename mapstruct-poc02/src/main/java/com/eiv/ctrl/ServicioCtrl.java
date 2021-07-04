package com.eiv.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.input.ServicioId;
import com.eiv.service.ServicioService;
import com.eiv.view.model.ServicioModel;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/servicios")
public class ServicioCtrl {

    private final ServicioService servicioService;

    @GetMapping
    private ResponseEntity<ServicioModel> buscarPorId(ServicioId servicioId) {

        ServicioModel servicio = servicioService.findById(servicioId);
        return ResponseEntity.ok(servicio);
    }

}
