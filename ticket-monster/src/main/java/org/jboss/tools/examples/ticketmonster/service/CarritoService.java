package org.jboss.tools.examples.ticketmonster.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Compra;
import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.model.Usuario;

public interface CarritoService {
	
	public void iniciarCarrito(String token);
	
	public Set<String> obtenerProductos();
	
	public void agregarProducto(String codigoProducto) throws BusinessException;
			
	public void eliminarProducto(String codigoProducto) throws BusinessException;
	
	public void vaciarCarrito() throws BusinessException;

//	public BigDecimal obtenerMonto();
//	
//	public Usuario obtenerUsuario();
	
	public String obtenerIdCarrito();
	
	public BigDecimal pagar() throws BusinessException;
	
	
	
	

}
