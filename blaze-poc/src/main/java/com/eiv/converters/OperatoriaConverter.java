package com.eiv.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.eiv.data.enums.OperatoriaEnum;

@Converter(autoApply = true)
public class OperatoriaConverter implements
        AttributeConverter<OperatoriaEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OperatoriaEnum attribute) {
        return attribute == null ? null : attribute.getDbValue();
    }

    @Override
    public OperatoriaEnum convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : OperatoriaEnum.of(dbData);
    }
}
