package com.eiv.poc.appparams.beans;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.eiv.poc.appparams.entities.ParametroEntity;
import com.eiv.poc.appparams.interfaces.ParametroEnum;

public class ParametrosStoreGlobalScope {
	
	private HashMap<Long, Set<ParametroEntity>> parametrosHashmap = null;
	
	public ParametrosStoreGlobalScope() {
		parametrosHashmap = new HashMap<Long, Set<ParametroEntity>>();
	}

	public HashMap<Long, Set<ParametroEntity>> getParametrosHashmap() {
		return parametrosHashmap;
	}

	public Set<ParametroEntity> getParametrosHashmap(Long entidadId) {
		return parametrosHashmap.get(entidadId);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getParametroValor(Long entidadId, ParametroEnum parametroEnum) {
		
		Optional<ParametroEntity> optional = parametrosHashmap.get(entidadId).stream()
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
	
	public void load(ParametroEntity parametroEntity) {
		
		Set<ParametroEntity> set = parametrosHashmap.get(parametroEntity.getEntidad().getId());
		
		if(set == null) {
			set = new HashSet<ParametroEntity>();
			parametrosHashmap.put(parametroEntity.getEntidad().getId(), set);
		}
		
		set.add(parametroEntity);
	}
	
	public ByEntidad filterByEntidadId(Long entidadId) {
		
		Set<ParametroEntity> set = parametrosHashmap.get(entidadId);
		ByEntidad byEntidad = new ByEntidad();
		
		if(set != null) {
			set.forEach(parametroEntity -> byEntidad.load(parametroEntity));
		}
		
		return byEntidad;
	}
	
	public class ByEntidad {

		private Set<ParametroEntity> parametrosEntities = null;
		
		public ByEntidad() {
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
}
