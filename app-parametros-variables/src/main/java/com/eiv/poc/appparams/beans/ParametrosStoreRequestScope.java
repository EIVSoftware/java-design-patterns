package com.eiv.poc.appparams.beans;

import java.util.HashMap;
import java.util.Map;

import com.eiv.poc.appparams.entities.ParametroEntity;
import com.eiv.poc.appparams.interfaces.ParametroEnum;

public class ParametrosStoreRequestScope {

	private Map<ParametroEnum, ParametroEntity> map = null;
	
	public ParametrosStoreRequestScope() {
		map = new HashMap<ParametroEnum, ParametroEntity>();
	}

	public void load(ParametroEntity parametroEntity) {
		map.put(parametroEntity.getParametro(), parametroEntity);
	}
	
	public void load(Map<ParametroEnum, ParametroEntity> map) {
		this.map = map;
	}

	@SuppressWarnings("unchecked")
	public <T> T getParametroValor(ParametroEnum parametroEnum) {
		
		ParametroEntity parametroEntity = map.get(parametroEnum);
		String rawValue = parametroEntity.getValor();
			
		if(parametroEntity.getParametro().getClazz().isAssignableFrom(Integer.class)) {
			Integer integer = Integer.valueOf(rawValue);
			return (T) integer;
		} else if(parametroEntity.getParametro().getClazz().isAssignableFrom(String.class)) {
			return (T) rawValue;
		}
		
		return null;
	}
	
}
