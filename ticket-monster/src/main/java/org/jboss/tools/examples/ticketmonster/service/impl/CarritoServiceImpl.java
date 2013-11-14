package org.jboss.tools.examples.ticketmonster.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateful;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Compra;
import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.model.Usuario;
import org.jboss.tools.examples.ticketmonster.service.CarritoService;

@Stateful
public class CarritoServiceImpl implements CarritoService {

	public CarritoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarProducto(String codigoProducto, Integer cantidad)
			throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarCantidadProducto(String codigoProducto,
			Integer cantidad) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarProducto(String codigoProducto)
			throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer obtenerCantidadProducto(String codigoProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal obtenerMonto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long obtenerIdCarrito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> pagar() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
