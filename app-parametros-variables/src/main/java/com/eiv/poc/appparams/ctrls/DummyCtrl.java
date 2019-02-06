package com.eiv.poc.appparams.ctrls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.poc.appparams.beans.ParametrosStoreGlobalScope;
import com.eiv.poc.appparams.enums.ParametroEnumImpl;

@RestController
public class DummyCtrl {
	
	private static final Logger LOG = LoggerFactory.getLogger(DummyCtrl.class);
	
	@Autowired private ParametrosStoreGlobalScope parametrosStoreGlobalScope = null;
	
	@GetMapping("/api/entidades/{entidadId}/parametrosuno")
	public String entidadValorParametroUno(@PathVariable("entidadId") Long entidadId) {

		Long start = System.nanoTime();
		
		Integer valor = parametrosStoreGlobalScope
				.filterByEntidadId(entidadId)
				.getParametroValor(ParametroEnumImpl.PARAMETRO_UNO);
		
		Long end = System.nanoTime();
		LOG.info("Enlapsed: {}", end - start);
		
		return valor.toString();
	}

	@GetMapping("/api/entidades/{entidadId}/parametrosdos")
	public String entidadValorParametroDos(@PathVariable("entidadId") Long entidadId) {

		String valor = parametrosStoreGlobalScope.getParametroValor(entidadId, ParametroEnumImpl.PARAMETRO_DOS);
		return valor;
	}
}
