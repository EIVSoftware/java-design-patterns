package com.eiv.das;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eiv.data.model.CuentaVistaAcuerdoEntity;
import com.eiv.data.model.QCuentaVistaAcuerdoEntity;
import com.eiv.repos.CuentaVistaAcuerdoRepository;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaVistaAcuerdoDas {

    private final CuentaVistaAcuerdoRepository cuentaVistaAcuerdoRepository;

    public Page<CuentaVistaAcuerdoEntity> findAll(
            Function<QCuentaVistaAcuerdoEntity, Predicate> queryCallback,
            Pageable pageable) {

        QCuentaVistaAcuerdoEntity q = QCuentaVistaAcuerdoEntity.cuentaVistaAcuerdoEntity;
        return cuentaVistaAcuerdoRepository.findAll(queryCallback.apply(q), pageable);
    }

}
