package org.jboss.tools.examples.ticketmonster.model;

import java.math.BigDecimal;
import java.util.Date;

public class Compra {

	private Date fecha;
	private BigDecimal monto;
	private Usuario user;
	private Producto producto;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	

}
