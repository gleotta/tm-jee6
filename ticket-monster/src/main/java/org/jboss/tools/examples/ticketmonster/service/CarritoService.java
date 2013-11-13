package org.jboss.tools.examples.ticketmonster.service;

import java.math.BigDecimal;
import java.util.List;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Compra;
import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.model.Usuario;

public interface CarritoService {
	
	public List<Producto> obtenerProductos();
	
	public void agregarProducto(String codigoProducto, Integer cantidad) throws BusinessException;
	
	public void modificarCantidadProducto(String codigoProducto, Integer cantidad) throws BusinessException;
	
	public void eliminarProducto(String codigoProducto) throws BusinessException;
	
	public Integer obtenerCantidadProducto(String codigoProducto);
	
	public BigDecimal obtenerMonto();
	
	public Usuario obtenerUsuario();
	
	public Long obtenerIdCarrito();
	
	public List<Compra> pagar() throws BusinessException;
	
	

}
