package com.eiv.das;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.eiv.data.model.CuentaVistaEntity;
import com.eiv.data.model.QCuentaVistaEntity;
import com.eiv.repos.CuentaVistaRepository;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaVistaDas {

    private final CuentaVistaRepository cuentaRepository;

    public Optional<CuentaVistaEntity> findOne(
            Function<QCuentaVistaEntity, Predicate> queryCallback) {

        QCuentaVistaEntity q = QCuentaVistaEntity.cuentaVistaEntity;
        return cuentaRepository.findOne(queryCallback.apply(q));
    }

}
