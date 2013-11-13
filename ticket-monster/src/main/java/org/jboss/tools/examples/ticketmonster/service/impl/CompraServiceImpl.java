package org.jboss.tools.examples.ticketmonster.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Compra;
import org.jboss.tools.examples.ticketmonster.service.CompraService;

public class CompraServiceImpl implements CompraService{

	public CompraServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Compra> obtenerCompras() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> obtenerComprasUsuario(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> obtenerComprasProducto(String codigoProd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearCompra(String username, String producto, BigDecimal monto)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
