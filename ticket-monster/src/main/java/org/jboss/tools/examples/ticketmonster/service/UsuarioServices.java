package org.jboss.tools.examples.ticketmonster.service;

import java.util.List;

import org.jboss.tools.examples.ticketmonster.model.Compra;
import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.model.Usuario;

public interface UsuarioServices {
	
	public List<Producto> busquedaProductos();
	
	public List<Producto> busquedaProductos(String busqueda);
	
	public Producto obtenerProducto(Long idProducto);
	
	public void registrarUsuario(Usuario u);
	
	public void login(Usuario u);
	
	public void logout(Usuario u);
	
	public List<Compra> obtenerCompras(Long usuarioId);
	
	
	
	//public void agregarCarrito(Long usuarioId, Long idProducto);
	
	
	
	

}
