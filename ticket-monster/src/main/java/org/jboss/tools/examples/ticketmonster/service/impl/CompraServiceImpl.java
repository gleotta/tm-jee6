package org.jboss.tools.examples.ticketmonster.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Compra;
import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.model.Usuario;
import org.jboss.tools.examples.ticketmonster.service.CompraService;
import org.jboss.tools.examples.ticketmonster.service.ProductosService;
import org.jboss.tools.examples.ticketmonster.service.UsuarioService;

public class CompraServiceImpl implements CompraService{

	@Inject 
	private ProductosService productoService;
	
	@Inject 
	private UsuarioService usuarioService;
	
	@Inject 
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> obtenerCompras() {
		return (List<Compra>) 
				entityManager.createQuery("select c from Compra c")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> obtenerComprasUsuario(String username) {
		return (List<Compra>) 
				entityManager.createQuery("select c from Compra c where c.usuario.email = :username")
				.setParameter("username", username)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> obtenerComprasProducto(String codigoProd) {
		
		return (List<Compra>) 
				entityManager.createQuery("select c from Compra c where c.producto.codigo = :codigo")
				.setParameter("codigo", codigoProd)
				.getResultList();
		
	}

	@Override
	public void crearCompra(String username, String producto, BigDecimal monto)
			throws BusinessException {
		Usuario usuario = usuarioService.obtenerUsuario(username);
		if (usuario==null) {
			throw new BusinessException("El usuario debe existir");
		}
		
		Producto p  = productoService.obtenerProducto(producto);
		if (producto==null) {
			throw new BusinessException("El producto debe existir");
		}
		
		Compra compra = new Compra();
		compra.setUsuario(usuario);
		compra.setProducto(p);
		compra.setMonto(monto);
		compra.setFecha(new Date());
		
		
		entityManager.persist(compra);

		
	}

	@Override
	public void crearCompra(Compra c) throws BusinessException {
		entityManager.persist(c);
		
	}

}
