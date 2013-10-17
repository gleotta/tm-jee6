package org.jboss.tools.examples.ticketmonster.model;

public class Disco extends Producto {
	
	private String artista;
	private CategoriaDisco categoria;
	private Integer cantidadTrack;



	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}


	public CategoriaDisco getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDisco categoria) {
		this.categoria = categoria;
	}

	public Integer getCantidadTrack() {
		return cantidadTrack;
	}

	public void setCantidadTrack(Integer cantidadTrack) {
		this.cantidadTrack = cantidadTrack;
	}

}
