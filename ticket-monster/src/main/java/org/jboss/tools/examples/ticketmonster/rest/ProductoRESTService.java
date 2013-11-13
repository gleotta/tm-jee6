package org.jboss.tools.examples.ticketmonster.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.service.ProductosService;

@Path("/producto")
@RequestScoped
public class ProductoRESTService {

	@Inject 
	private ProductosService productoService;
	
	@GET
	@Path("/{tipo}/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> buscarProductos(@PathParam("tipo") String tipo, @QueryParam("titulo") String titulo) {
		
		try {
			return productoService.buscarProductos(tipo, titulo);
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> buscarProductos(@QueryParam("titulo") String titulo) {
		
		try {
			return productoService.buscarProductos(null, titulo);
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Path("/get/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Producto obtenerProducto(@PathParam("codigo") String codigo) {
		try {
			Producto p =  productoService.obtenerProducto(codigo);
			if (p==null) {
				throw new WebApplicationException(Status.NOT_FOUND);
			}
			return p;
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}

}
