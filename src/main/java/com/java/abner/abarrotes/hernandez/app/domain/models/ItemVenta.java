package com.java.abner.abarrotes.hernandez.app.domain.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "items_ventas")
public class ItemVenta implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public ItemVenta() {
		
		
	}

	@ManyToOne
	private Producto producto;

	@ManyToOne
	private Lote lote;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Venta venta;

	private Integer cantidad;


	@Column(columnDefinition = "Decimal(10,2)")
	private Float ganancia;
	@Column(columnDefinition = "Decimal(10,2)")
	private Float  total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Float getGanancia() {
		return ganancia;
	}

	public void setGanancia(Float ganancia) {
		this.ganancia = ganancia;
	}

}
