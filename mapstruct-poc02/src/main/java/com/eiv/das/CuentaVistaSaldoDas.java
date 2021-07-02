package com.eiv.das;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.eiv.data.model.CuentaVistaSaldoEntity;
import com.eiv.data.model.QCuentaVistaSaldoEntity;
import com.querydsl.core.types.Predicate;

@Service
public class CuentaVistaSaldoDas {

    public Optional<CuentaVistaSaldoEntity> findOne(
            Function<QCuentaVistaSaldoEntity, Predicate> queryCallback) {

        CuentaVistaSaldoEntity saldo = CuentaVistaSaldoEntity.builder()
                .saldo(new BigDecimal("1234.567"))
                .build();

        return Optional.of(saldo);
    }

}
