package com.eiv.poc.appparams.enums;

import com.eiv.poc.appparams.interfaces.ParametroEnum;

public enum ParametroEnumImpl implements ParametroEnum {
	PARAMETRO_UNO(1, Integer.class),
	PARAMETRO_DOS(2, String.class);
	
	private int dbValue;
	private Class<?> clazz;
	
	private ParametroEnumImpl(int dbValue, Class<?> clazz) {
		this.dbValue = dbValue;
		this.clazz = clazz;
	}

	@Override
	public int getDbValue() {
		return dbValue;
	}

	@Override
	public Class<?> getClazz() {
		return clazz;
	}
	
	public static ParametroEnumImpl fromDbValue(int dbValue) {
		switch(dbValue) {
		case 1:
			return PARAMETRO_UNO;
		case 2:
			return PARAMETRO_DOS;
		default:
			throw new IllegalArgumentException(
				String.format("El valor de base de datos %s no es válido!", dbValue));
		}
	}
}
