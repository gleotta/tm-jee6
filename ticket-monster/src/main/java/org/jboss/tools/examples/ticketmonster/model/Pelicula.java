package org.jboss.tools.examples.ticketmonster.model;

public class Pelicula extends Producto {

	private String director; 
	private Integer duracion;
	private Genero genero;


	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	
}
