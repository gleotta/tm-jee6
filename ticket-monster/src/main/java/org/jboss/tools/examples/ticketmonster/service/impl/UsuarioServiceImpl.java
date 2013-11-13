package org.jboss.tools.examples.ticketmonster.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.ticketmonster.exceptions.BusinessException;
import org.jboss.tools.examples.ticketmonster.exceptions.TechnicalException;
import org.jboss.tools.examples.ticketmonster.model.Usuario;
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

	@Override
	public String login(String email, String password) {
		return new Date().getTime()+"";
		
	}

	@Override
	public void logout(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLoged(String email) {
		// TODO Auto-generated method stub
		return false;
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
