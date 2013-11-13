package org.jboss.tools.examples.ticketmonster.service;

import java.util.List;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Usuario;

public interface UsuarioService {
	
	public void registrarUsuario(Usuario u) throws BusinessException;
	
	public String login(String username, String password);
	
	public void logout(String username);
		
	public boolean isLoged(String username);
	
	public Usuario obtenerUsuario(String username);
	
	public List<Usuario> obtenerUsarios();
	

}
