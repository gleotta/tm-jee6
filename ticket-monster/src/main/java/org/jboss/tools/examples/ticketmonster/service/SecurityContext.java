package org.jboss.tools.examples.ticketmonster.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class SecurityContext {

	private Map<String, String> sessions;
	
	@PostConstruct
	private void init() {
		sessions = new HashMap<String, String>();
	}
	
	
	private String generateToken(String username) {
		return new Date().getTime()+"";
	}
	public String createToken(String username) {
		String token = generateToken(username);
		sessions.put(token,username);
		return token;
	}
	
	public String getUserToken(String token) {
		return sessions.get(token);
	}
	
	public void invalidateToken(String token) {
		sessions.remove(token);
	}
	
	
	
	
	
}
