package com.java.abner.abarrotes.hernandez.app.domain.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@Column(columnDefinition = "Decimal(10,2)")
	private Float precio;

	private Integer cantidad;

	@Column(columnDefinition = "Decimal(10,2)")
	private Float precioU;

	@Column(nullable = false)
	private Boolean onStock;

	public Producto() {
	}

	@PrePersist
	public void prePersist() {
		setOnStock(true);
	}

	public Producto(Long id, String nombre, Float precio, Integer cantidad, Boolean onStock) {

		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.onStock = onStock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getPrecioU() {
		return precioU;
	}

	public void setPrecioU(Float precioU) {
		this.precioU = precioU;
	}

	public Boolean getOnStock() {
		return onStock;
	}

	public void setOnStock(Boolean onStock) {
		this.onStock = onStock;
	}

}
