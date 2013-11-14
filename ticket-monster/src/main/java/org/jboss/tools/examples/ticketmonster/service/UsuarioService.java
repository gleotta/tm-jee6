package org.jboss.tools.examples.ticketmonster.service;

import java.util.List;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.model.Usuario;

public interface UsuarioService {
	
	public void registrarUsuario(Usuario u) throws BusinessException;
	
	public String login(String username, String password) throws BusinessException;
	
	public void logout(String token) throws BusinessException ;
		
	public boolean isLoged(String token);
	
	public Usuario obtenerUsuario(String username);
	
	public List<Usuario> obtenerUsarios();
	

}
