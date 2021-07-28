package com.eiv.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.service.SucursalService;
import com.eiv.view.model.SucursalModel;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sucursales")
public class SucursalCtrl {

    private final SucursalService sucursalService;

    @GetMapping(path = "/{id}")
    private ResponseEntity<SucursalModel> buscarPorId(
            @PathVariable(name = "id", required = true) Long id) {

        Optional<SucursalModel> sucursalModel = sucursalService.findById(id);
        if (sucursalModel.isPresent()) {
            return ResponseEntity.ok(sucursalModel.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    private ResponseEntity<List<SucursalModel>> buscarTodos() {

        List<SucursalModel> sucursalModels = sucursalService.findAll();
        return ResponseEntity.ok(sucursalModels);
    }

    @GetMapping(path = "/nombres")
    private ResponseEntity<List<String>> buscarNombres() {

        List<String> nombres = sucursalService.findAllNombres();
        return ResponseEntity.ok(nombres);
    }

}
