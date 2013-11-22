package org.jboss.tools.examples.ticketmonster.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.service.CarritoService;
import org.jboss.tools.examples.ticketmonster.service.CompraService;
import org.jboss.tools.examples.ticketmonster.service.ProductosService;
import org.jboss.tools.examples.ticketmonster.service.SecurityContext;
import org.jboss.tools.examples.ticketmonster.service.UsuarioService;

@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 30)
public class CarritoServiceImpl implements CarritoService {

	
	@Inject ProductosService productoService;
	
	@Inject UsuarioService usuarioService;
	
	@Inject CompraService compraService;
	
	@Inject SecurityContext securityContext;
	
	
	
	private Set<String> productos;
	
	private String token;
	
	public void iniciarCarrito(String token) {
		this.token = token;
		productos = new HashSet<String>();
	}
	
	@Override
	public Set<String> obtenerProductos() {
		
		return productos;
	}

	@Override
	public void agregarProducto(String codigoProducto)
			throws BusinessException {
		productos.add(codigoProducto);

	}

	
	@Override
	public void eliminarProducto(String codigoProducto)
			throws BusinessException {
		productos.remove(codigoProducto);

	}

	
//	@Override
//	public BigDecimal obtenerMonto() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Usuario obtenerUsuario() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String obtenerIdCarrito() {
		
		return token;
	}


	@Override
	public BigDecimal pagar() throws BusinessException {
		Date date = new Date();
		double monto = 0.0;
		String username = securityContext.getUserToken(token);
		for (String producto : productos) {
			Producto pr = productoService.obtenerProducto(producto);
			monto = monto + pr.getPrecio().doubleValue();
			compraService.crearCompra(username, pr.getCodigo(), date);
		}
		return new BigDecimal(monto);
	}

	@Override
	public void vaciarCarrito() throws BusinessException {
		productos = new HashSet<String>();
		
	}

	

}
