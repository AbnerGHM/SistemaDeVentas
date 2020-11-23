package com.java.abner.abarrotes.hernandez.app.domain.models;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

@Component
public class Resume {

	private String nombreProducto;
	private Long suma;
	@Column(columnDefinition = "Decimal(10,2)")
	private Float precioU;
	@Column(columnDefinition = "Decimal(10,2)")
	private Float precio;
	@Column(columnDefinition = "Decimal(10,2)")
	private Float subtotal;

	public Resume() {

	}

	public Resume(String nombreProducto, Long suma, Float precioU, Float precio, Float subtotal) {
		
		this.nombreProducto = nombreProducto;
		this.suma = suma;
		this.precioU = precioU;
		this.precio = precio;
		this.subtotal = subtotal;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Long getSuma() {
		return suma;
	}

	public void setSuma(Long suma) {
		this.suma = suma;
	}

	public Float getPrecioU() {
		return precioU;
	}

	public void setPrecioU(Float precioU) {
		this.precioU = precioU;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}





	
}
