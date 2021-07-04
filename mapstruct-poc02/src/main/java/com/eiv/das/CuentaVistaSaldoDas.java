package com.eiv.das;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.eiv.data.model.CuentaVistaSaldoEntity;
import com.eiv.data.model.QCuentaVistaSaldoEntity;
import com.eiv.repos.CuentaVistaSaldoRepository;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaVistaSaldoDas {

    private final CuentaVistaSaldoRepository cuentaVistaSaldoRepository;

    public Optional<CuentaVistaSaldoEntity> findOne(
            Function<QCuentaVistaSaldoEntity, Predicate> queryCallback) {

        QCuentaVistaSaldoEntity q = QCuentaVistaSaldoEntity.cuentaVistaSaldoEntity;
        return cuentaVistaSaldoRepository.findOne(queryCallback.apply(q));
    }

}
