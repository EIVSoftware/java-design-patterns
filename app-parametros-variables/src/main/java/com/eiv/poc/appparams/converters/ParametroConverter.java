package com.eiv.poc.appparams.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.eiv.poc.appparams.enums.ParametroEnumImpl;

@Converter
public class ParametroConverter implements AttributeConverter<ParametroEnumImpl, Integer> {

	@Override
	public Integer convertToDatabaseColumn(ParametroEnumImpl attribute) {
		return attribute.getDbValue();
	}

	@Override
	public ParametroEnumImpl convertToEntityAttribute(Integer dbData) {
		return ParametroEnumImpl.fromDbValue(dbData);
	}
}
