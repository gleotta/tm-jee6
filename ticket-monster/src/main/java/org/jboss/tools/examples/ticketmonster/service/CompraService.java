package org.jboss.tools.examples.ticketmonster.service;

import java.util.List;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Compra;

public interface CompraService {
	
	public List<Compra> obtenerCompras();
	
	public List<Compra> obtenerComprasUsuario(String username);
	
	public List<Compra> obtenerComprasProducto(String codigoProd);
	
	public void crearCompra(String username, String producto) throws BusinessException;
	
	public void crearCompra(Compra c) throws BusinessException;

}
