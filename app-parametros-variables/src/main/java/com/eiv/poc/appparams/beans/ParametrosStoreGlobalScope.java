package com.eiv.poc.appparams.beans;

import java.util.HashMap;
import java.util.Map;

import com.eiv.poc.appparams.entities.ParametroEntity;
import com.eiv.poc.appparams.interfaces.ParametroEnum;

public class ParametrosStoreGlobalScope {
	
	private HashMap<Long, Map<ParametroEnum, ParametroEntity>> parametrosHashmap = null;
	
	public ParametrosStoreGlobalScope() {
		parametrosHashmap = new HashMap<Long, Map<ParametroEnum, ParametroEntity>>();
	}

	public HashMap<Long, Map<ParametroEnum, ParametroEntity>> getParametrosHashmap() {
		return parametrosHashmap;
	}

	public Map<ParametroEnum, ParametroEntity> getParametrosHashmap(Long entidadId) {
		return parametrosHashmap.get(entidadId);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getParametroValor(Long entidadId, ParametroEnum parametroEnum) {
		
		Map<ParametroEnum, ParametroEntity> map = parametrosHashmap.get(entidadId);
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
	
	public void load(ParametroEntity parametroEntity) {
		
		Map<ParametroEnum, ParametroEntity> map = parametrosHashmap.get(parametroEntity.getEntidad().getId());
		
		if(map == null) {
			map = new HashMap<ParametroEnum, ParametroEntity>();
			parametrosHashmap.put(parametroEntity.getEntidad().getId(), map);
		}
		
		map.put(parametroEntity.getParametro(), parametroEntity);
	}
	
	public ByEntidad filterByEntidadId(Long entidadId) {
		
		Map<ParametroEnum, ParametroEntity> map = parametrosHashmap.get(entidadId);
		ByEntidad byEntidad = new ByEntidad();
		
		if(map != null) {
			byEntidad.load(map);
		}
		
		return byEntidad;
	}
	
	public class ByEntidad {

		private Map<ParametroEnum, ParametroEntity> map = null;
		
		public ByEntidad() {
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
}
