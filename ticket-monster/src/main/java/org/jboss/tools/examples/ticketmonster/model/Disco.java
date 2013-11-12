package org.jboss.tools.examples.ticketmonster.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="DISCO")
public class Disco extends Producto {
	
	@NotNull
	private String artista;
	
	@ManyToOne
	@NotNull
	private CategoriaDisco categoria;
	
	@Min(1)
	@NotNull
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
