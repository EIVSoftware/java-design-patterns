package com.eiv.poc.appparams.cfg;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;

import com.eiv.poc.appparams.beans.ParametrosStoreGlobalScope;
import com.eiv.poc.appparams.beans.ParametrosStoreRequestScope;
import com.eiv.poc.appparams.entities.ParametroEntity;
import com.eiv.poc.appparams.interfaces.ParametroEnum;
import com.eiv.poc.appparams.repositories.ParametroRepository;

@Configuration
public class ParametrosConfig {

	private static final Logger LOG = LoggerFactory.getLogger(ParametrosConfig.class);
	
	@Autowired private ParametroRepository parametroRepository = null;
	
	@Bean
	public ParametrosStoreGlobalScope getParametrosStore() {
		ParametrosStoreGlobalScope parametrosStore = new ParametrosStoreGlobalScope();
		parametroRepository.findAll().stream().forEach(parametroEntity -> {
			LOG.debug("Agregando parametro de la entidad {}", parametroEntity);
			parametrosStore.load(parametroEntity);
		});
		return parametrosStore;
	}
	
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ParametrosStoreRequestScope getParametrosStoreRequestScope() {
		return new ParametrosStoreRequestScope();
	}
	
	@Bean
	public FilterRegistrationBean<OncePerRequestFilter> registerFilter() {
		FilterRegistrationBean<OncePerRequestFilter> filter = new FilterRegistrationBean<OncePerRequestFilter>();
		filter.setFilter(new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
				
				String header = request.getHeader("entidadid");
				
				if(header != null && !header.trim().isEmpty()) {
					
					ParametrosStoreGlobalScope globalScope = getParametrosStore();
					Map<ParametroEnum, ParametroEntity> map = globalScope.getParametrosHashmap(Long.valueOf(header));
					
					ParametrosStoreRequestScope requestScope = getParametrosStoreRequestScope();
					requestScope.load(map);
				}
				
				filterChain.doFilter(request, response);
			}
		});
		return filter;
	}
}
