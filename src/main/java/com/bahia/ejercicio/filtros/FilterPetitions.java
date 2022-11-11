package com.bahia.ejercicio.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class FilterPetitions implements Filter {

	   @Override
	   public void destroy() {}

	   @Override
	   public void doFilter
	      (ServletRequest request, ServletResponse response, FilterChain filterchain) 
	      throws IOException, ServletException {
	        HttpServletRequest req = (HttpServletRequest) request;
	        log.info("Iniciar una transacción para request : {}", 
	          req.getRequestURI());
	 
	        filterchain.doFilter(request, response);
	        log.info("Confirmar una transacción para request : {}", 
	          req.getRequestURI());
	      }

	   @Override
	   public void init(FilterConfig filterconfig) throws ServletException {
		   log.info("########## Iniciando FilterPetitions ##########");
	   }

}
