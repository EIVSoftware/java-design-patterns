package com.eiv.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.eiv.data.enums.ServicioEstadoEnum;

@Converter(autoApply = true)
public class ServicioEstadoConverter implements AttributeConverter<ServicioEstadoEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ServicioEstadoEnum attribute) {
        return attribute == null ? null : attribute.getDbValue();
    }

    @Override
    public ServicioEstadoEnum convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : ServicioEstadoEnum.of(dbData);
    }
}