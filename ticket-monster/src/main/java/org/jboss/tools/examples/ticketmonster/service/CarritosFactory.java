package org.jboss.tools.examples.ticketmonster.service;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Singleton
public class CarritosFactory {
	
	private Map<String, CarritoService> carritos = new HashMap<String, CarritoService>();

	public CarritoService crearCarrito(String token) {
		try {
			InitialContext ic = new InitialContext();
			CarritoService carritoService = (CarritoService) ic.lookup("java:module/CarritoServiceImpl");
			carritoService.iniciarCarrito(token);
			carritos.put(token, carritoService);
			return carritoService;
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public CarritoService getCarrito(String token) {
		return carritos.get(token);
		
	}

}
