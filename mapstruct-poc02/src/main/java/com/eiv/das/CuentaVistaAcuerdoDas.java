package com.eiv.das;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.eiv.data.model.CuentaVistaAcuerdoEntity;
import com.eiv.data.model.QCuentaVistaAcuerdoEntity;
import com.querydsl.core.types.Predicate;

@Service
public class CuentaVistaAcuerdoDas {

    public Page<CuentaVistaAcuerdoEntity> findAll(
            Function<QCuentaVistaAcuerdoEntity, Predicate> queryCallback) {

        List<CuentaVistaAcuerdoEntity> acuerdos = Arrays.asList(
                CuentaVistaAcuerdoEntity.builder()
                    .importe(new BigDecimal("00.01"))
                    .build(),
                CuentaVistaAcuerdoEntity.builder()
                    .importe(new BigDecimal("00.10"))
                    .build(),
                CuentaVistaAcuerdoEntity.builder()
                    .importe(new BigDecimal("01.00"))
                    .build(),
                CuentaVistaAcuerdoEntity.builder()
                    .importe(new BigDecimal("10.00"))
                    .build());

        return new PageImpl<>(acuerdos);
    }

}
