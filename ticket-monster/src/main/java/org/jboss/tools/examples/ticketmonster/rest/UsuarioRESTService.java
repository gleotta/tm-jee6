package org.jboss.tools.examples.ticketmonster.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Usuario;
import org.jboss.tools.examples.ticketmonster.service.UsuarioService;

@Path("/usuario")
@RequestScoped
public class UsuarioRESTService {

	@Inject
    private Logger log;
	
	@Inject 
	private UsuarioService usuarioService;
	
	@GET
	@Path("/get/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario obtenerUsuario(@PathParam("username") String username) {
		try {
			Usuario ret = usuarioService.obtenerUsuario(username);
			if (ret==null) {
				
				throw new WebApplicationException(Status.NOT_FOUND);
			}
			
			return ret;
		} catch (Exception e) {
			Response r = Response.serverError().entity(e.getMessage()).build();
			throw new WebApplicationException(r);
		}
	}
	
	@GET
	@Path("/isLoged/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean isLoged(@PathParam("username") String username) {
		try {
			return usuarioService.isLoged(username);
		} catch (Exception e) {
			Response r = Response.serverError().entity(e.getMessage()).build();
			throw new WebApplicationException(r);
		}
	}
	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public void registrarUsuario(Usuario u) {
		try {
			usuarioService.registrarUsuario(u);
		} catch (BusinessException e) {
			Response r = Response.serverError().entity(e.getMessage()).build();
			throw new WebApplicationException(r);
		}
		
	}

	@POST
	@Path("/login/{username}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String login(@PathParam("username") String email, String password) {
		try {
			return usuarioService.login(email, password);
		} catch (Exception e) {
			Response r = Response.serverError().entity(e.getMessage()).build();
			throw new WebApplicationException(r);
		}
	}

	@POST
	@Path("/logout/{username}")
	public void logout(@PathParam("username") String username) {
		try {
			usuarioService.logout(username);
		} catch (Exception e) {
			log.severe(e.getMessage());
			Response r = Response.serverError().entity(e.getMessage()).build();
			throw new WebApplicationException(r);
		}
		
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> obtenerUsuarios() {
		try {
			return usuarioService.obtenerUsarios();
		} catch (Exception e) {
			throw new WebApplicationException(e, Status.fromStatusCode(500));
		}
		
	}

	

	

	

}
