package org.jboss.tools.examples.ticketmonster.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.ticketmonster.model.Compra;
import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.model.Usuario;

@Stateless
public class UsuarioServicesImpl implements UsuarioServices {
	
	@Inject
	private EntityManager em;

	@Override
	public List<Producto> busquedaProductos() {
		// TODO Auto-generated method stub
		List<Producto> ret = em.createQuery("select p from Producto p").getResultList();
		return ret;
	}

	@Override
	public List<Producto> busquedaProductos(String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtenerProducto(Long idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarUsuario(Usuario u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void login(Usuario u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logout(Usuario u) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Compra> obtenerCompras(Long usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

}
