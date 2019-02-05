package com.eiv.poc.appparams.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.poc.appparams.beans.ParametrosStoreGlobalScope;
import com.eiv.poc.appparams.enums.ParametroEnumImpl;

@RestController
public class DummyCtrl {
	
	@Autowired private ParametrosStoreGlobalScope parametrosStoreGlobalScope = null;
	
	@GetMapping("/api/entidades/{entidadId}/parametrosuno")
	public String entidadValorParametroUno(@PathVariable("entidadId") Long entidadId) {

		Integer valor = parametrosStoreGlobalScope
				.filterByEntidadId(entidadId)
				.getParametroValor(ParametroEnumImpl.PARAMETRO_UNO);
		
		return valor.toString();
	}

	@GetMapping("/api/entidades/{entidadId}/parametrosdos")
	public String entidadValorParametroDos(@PathVariable("entidadId") Long entidadId) {

		String valor = parametrosStoreGlobalScope.getParametroValor(entidadId, ParametroEnumImpl.PARAMETRO_DOS);
		return valor;
	}
}
