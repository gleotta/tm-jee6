package org.jboss.tools.examples.ticketmonster.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Compra;
import org.jboss.tools.examples.ticketmonster.service.CompraService;

@Path("/compra")
@RequestScoped
public class CompraRESTService {

	@Inject
	private CompraService compraService;

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compra> obtenerCompras() {
		return compraService.obtenerCompras();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearCompra(Compra compra) {
		try {
			compraService.crearCompra(compra);
		} catch (BusinessException e) {
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}
}
