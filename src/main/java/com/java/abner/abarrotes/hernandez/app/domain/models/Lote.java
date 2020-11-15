package com.java.abner.abarrotes.hernandez.app.domain.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Lotes")
public class Lote implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Id
	@Column(name = "no_lote")
	private String noLote;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_de_caducidad")
	private Date  fechadeCaducidad;
	
	@ManyToOne(fetch = FetchType.LAZY )
	private Producto producto;
	

	public String getNoLote() {
		return noLote;
	}

	public void setNoLote(String noLote) {
		this.noLote = noLote;
	}

	public Date getFechadeCaducidad() {
		return fechadeCaducidad;
	}

	public void setFechadeCaducidad(Date fechadeCaducidad) {
		this.fechadeCaducidad = fechadeCaducidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}





	
	
}
