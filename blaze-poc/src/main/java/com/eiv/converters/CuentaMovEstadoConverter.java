package com.eiv.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.eiv.data.enums.CuentaMovEstadoEnum;

@Converter(autoApply = true)
public class CuentaMovEstadoConverter implements
        AttributeConverter<CuentaMovEstadoEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CuentaMovEstadoEnum attribute) {
        return attribute == null ? null : attribute.getDbValue();
    }

    @Override
    public CuentaMovEstadoEnum convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : CuentaMovEstadoEnum.of(dbData);
    }
}