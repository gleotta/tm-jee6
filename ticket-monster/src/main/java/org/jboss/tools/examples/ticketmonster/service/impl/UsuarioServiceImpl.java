package org.jboss.tools.examples.ticketmonster.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.exceptions.TechnicalException;
import org.jboss.tools.examples.ticketmonster.model.Usuario;
import org.jboss.tools.examples.ticketmonster.service.SecurityContext;
import org.jboss.tools.examples.ticketmonster.service.UsuarioService;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {
	
	
	@Inject
	private EntityManager em;

	@Inject Logger log;
	
	@Override
	public void registrarUsuario(Usuario u) throws BusinessException{
		
		try {
			em.persist(u);
		} catch (Exception e) {
			throw new TechnicalException("Error al crear usuarrio", e);
		}

	}
	
	@Inject 
	private SecurityContext sc;

	@Override
	public String login(String email, String password) throws BusinessException{
		
		Usuario u = this.obtenerUsuario(email);
		if (!u.getContrasenia().equals(password)) {
			throw new BusinessException("El usuario o contraseña es invalida");
		}
		String ret = sc.createToken(email);
		return ret;
	}

	@Override
	public void logout(String token)  throws BusinessException {
		if (!this.isLoged(token))
			throw new BusinessException("No existe sessión para el token "+token);
		sc.invalidateToken(token);
		
	}

	@Override
	public boolean isLoged(String token) {
		
		return (sc.getUserToken(token)!=null);
	}

	@Override
	public Usuario obtenerUsuario(String email) {
		try {
			Usuario ret = (Usuario) em
					.createQuery("select u from Usuario u fetch all properties where u.email = :email")
					.setParameter("email", email).getSingleResult();
			return ret;
		} catch (Exception e) {
			log.warning(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> obtenerUsarios() {
		try {
			return (List<Usuario>) em
					.createQuery("select u from Usuario u").getResultList();
		} catch (Exception e) {
			
			throw new TechnicalException("Error al obtener usuarios", e);
		}
	}



	

}
