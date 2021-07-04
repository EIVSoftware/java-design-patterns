package com.eiv.das;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eiv.data.model.ServicioEntity;
import com.eiv.data.pk.ServicioPkEntity;
import com.eiv.repos.ServicioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioDas {

    private final ServicioRepository servicioRepository;

    public Optional<ServicioEntity> findById(ServicioPkEntity pk) {

        return servicioRepository.findById(pk);
    }

}
