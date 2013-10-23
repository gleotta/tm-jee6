package org.jboss.tools.examples.ticketmonster.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Entity
public class Software extends Producto {
	
	@NotNull
	private String autor;
		
	private String licencia;
	
	@DecimalMin("0.01")
	private BigDecimal tamanio;
	
	@ManyToOne
	@NotNull
	private CategoriaSoftware categoria;

	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public BigDecimal getTamanio() {
		return tamanio;
	}

	public void setTamanio(BigDecimal tamanio) {
		this.tamanio = tamanio;
	}

	public CategoriaSoftware getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaSoftware categoria) {
		this.categoria = categoria;
	}

	
}
