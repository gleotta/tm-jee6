package org.jboss.tools.examples.ticketmonster.rest;

import java.math.BigDecimal;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.service.CarritoService;
import org.jboss.tools.examples.ticketmonster.service.CarritosFactory;
import org.jboss.tools.examples.ticketmonster.service.CompraService;
import org.jboss.tools.examples.ticketmonster.service.UsuarioService;

@Path("/carrito")
@RequestScoped
public class CarritoRESTService {


	@Inject
	private UsuarioService usuarioService;

	@Context
	private HttpHeaders header;

	@Inject
	private CarritosFactory carritosFactory;

	private String token;

	@PostConstruct
	public void init() {
		String token = header.getRequestHeaders().getFirst("token");
		if (token == null || !usuarioService.isLoged(token))
			throw new WebApplicationException(Status.FORBIDDEN);
		this.token = token;
	}
	
	
	@POST
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearCarrito() {
		try {
			carritosFactory.crearCarrito(token);
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	};
	
	@GET
	@Path("/id")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCarritoId() {
		try {
			return carritosFactory.getCarrito(token).obtenerIdCarrito();
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	};
	
	@POST
	@Path("/agregar/{codigoProducto}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void agregarProducto(@PathParam("codigoProducto") String codigoProducto) {
		try {
			carritosFactory.getCarrito(token).agregarProducto(codigoProducto);
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Path("/eliminar/{codigoProducto}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void eliminarProducto(@PathParam("codigoProducto") String codigoProducto) {
		try {
			carritosFactory.getCarrito(token).eliminarProducto(codigoProducto);
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Path("/vaciar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void vaciar() {
		try {
			carritosFactory.getCarrito(token).vaciarCarrito();
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Path("/pagar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String pagar() {
		try {
			BigDecimal monto = carritosFactory.getCarrito(token).pagar();
			return monto.toString();
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<String> listar() {
		try {
			return carritosFactory.getCarrito(token).obtenerProductos();
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		
	}


}
