package org.jboss.tools.examples.ticketmonster.rest;

import java.util.List;

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

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Compra;
import org.jboss.tools.examples.ticketmonster.service.CompraService;
import org.jboss.tools.examples.ticketmonster.service.UsuarioService;

@Path("/compra")
@RequestScoped
public class CompraRESTService {

	@Inject
	private CompraService compraService;
	
	@Inject
	private UsuarioService usuarioService;
	

	@Context HttpHeaders header;
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compra> obtenerCompras() {
		String token = header.getRequestHeaders().getFirst("token");
		if (!usuarioService.isLoged(token))
			throw new WebApplicationException(Status.FORBIDDEN);
		return compraService.obtenerCompras();
	}

	@POST
	@Path("/create/{username}/{codProducto}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearCompra(@PathParam("username") String username,@PathParam("codProducto") String codProducto) {
		try {
			String token = header.getRequestHeaders().getFirst("token");
			if (!usuarioService.isLoged(token))
				throw new WebApplicationException(Status.FORBIDDEN);
			compraService.crearCompra(username, codProducto);
		} catch (BusinessException e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}
}
