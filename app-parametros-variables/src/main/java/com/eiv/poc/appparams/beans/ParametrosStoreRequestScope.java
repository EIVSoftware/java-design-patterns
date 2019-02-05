package com.eiv.poc.appparams.beans;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.eiv.poc.appparams.entities.ParametroEntity;
import com.eiv.poc.appparams.interfaces.ParametroEnum;

public class ParametrosStoreRequestScope {

	private Set<ParametroEntity> parametrosEntities = null;
	
	public ParametrosStoreRequestScope() {
		parametrosEntities = new HashSet<ParametroEntity>();
	}

	public void load(ParametroEntity parametroEntity) {
		parametrosEntities.add(parametroEntity);
	}

	@SuppressWarnings("unchecked")
	public <T> T getParametroValor(ParametroEnum parametroEnum) {
		
		Optional<ParametroEntity> optional = parametrosEntities.stream()
				.filter(p -> p.getParametro().equals(parametroEnum))
				.findFirst();
		
		if(optional.isPresent()) {
			
			ParametroEntity parametroEntity = optional.get();
			String rawValue = parametroEntity.getValor();
				
			if(parametroEntity.getParametro().getClazz().isAssignableFrom(Integer.class)) {
				Integer integer = Integer.valueOf(rawValue);
				return (T) integer;
			} else if(parametroEntity.getParametro().getClazz().isAssignableFrom(String.class)) {
				return (T) rawValue;
			}
		}
		
		return null;
	}
	
}
