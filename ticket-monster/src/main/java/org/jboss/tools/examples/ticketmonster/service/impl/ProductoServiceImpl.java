package org.jboss.tools.examples.ticketmonster.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.exceptions.TechnicalException;
import org.jboss.tools.examples.ticketmonster.model.Disco;
import org.jboss.tools.examples.ticketmonster.model.Pelicula;
import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.model.Software;
import org.jboss.tools.examples.ticketmonster.service.ProductosService;

@Stateless
public class ProductoServiceImpl implements ProductosService {

	@Inject
	private EntityManager em;
	
	@Inject 
	private Logger log;

	public ProductoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> buscarProductos(String tipo, String titulo) {
		String producto = null;
		if (tipo == null)
				producto = Producto.class.getSimpleName();
		else 	if (tipo.toLowerCase().equals("software"))
				producto = Software.class.getSimpleName();
		else if (tipo.toLowerCase().equals("disco"))
				producto = Disco.class.getSimpleName();
		else if (tipo.toLowerCase().equals("pelicula"))
				producto = Pelicula.class.getSimpleName();
		else 
				producto = Producto.class.getSimpleName();
		if (titulo == null)
			titulo = "";
		
		List<Producto> ret = em
				.createQuery(
						"select p from "
								+ producto
								+ " p "
								+ "where lower(p.titulo) like :titulo or :titulo = ''"
								)
				.setParameter("titulo", "%"+titulo.toLowerCase()+"%")
				.getResultList();

		return ret;
	}

	@Override
	public Producto obtenerProducto(String codigo) {
		
		try {
			Producto ret = (Producto) em
					.createQuery(
							"select p from Producto p where p.codigo = :codigo")
					.setParameter("codigo", codigo).getSingleResult();
			
			return ret;
		} catch (Exception e) {
			log.severe(e.getMessage());
			return null;
		}
	}

}
