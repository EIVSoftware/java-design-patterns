package com.eiv.poc.appparams.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiv.poc.appparams.beans.ParametrosStoreRequestScope;
import com.eiv.poc.appparams.enums.ParametroEnumImpl;

@RestController
public class DummyHeaderCtrl {

	@Autowired private ParametrosStoreRequestScope parametrosStoreRequestScope = null;
	
	@GetMapping("/api/parametrosuno")
	public String valorParametroUno() {
		Integer valor = parametrosStoreRequestScope.getParametroValor(ParametroEnumImpl.PARAMETRO_UNO);
		return valor.toString();
	}

	@GetMapping("/api/parametrosdos")
	public String valorParametroDos() {
		String valor = parametrosStoreRequestScope.getParametroValor(ParametroEnumImpl.PARAMETRO_DOS);
		return valor;
	}

}
