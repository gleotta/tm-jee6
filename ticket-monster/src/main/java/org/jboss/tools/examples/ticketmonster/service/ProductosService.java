package org.jboss.tools.examples.ticketmonster.service;

import java.util.List;

import org.jboss.tools.examples.ticketmonster.model.Producto;

public interface ProductosService {
	
	public List<Producto> buscarProductos(String tipo, String titulo);
	
	public Producto obtenerProducto(String codigo);
}
