package com.java.abner.abarrotes.hernandez.app.domain.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "Decimal(10,2)")
	private Float total;

	@Temporal(TemporalType.DATE)
	private Date fecha;
	

	@JsonManagedReference
	@JoinColumn(name = "venta_id")
	@OneToMany( cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<ItemVenta> itemVenta;

	@PrePersist
	public void prePersist() {
		if (this.fecha == null) {
			fecha = new Date();
		}

	}

	public Venta() {
		this.itemVenta = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<ItemVenta> getItemVenta() {
		return itemVenta;
	}

	public void setItemVenta(List<ItemVenta> itemVenta) {
		this.itemVenta = itemVenta;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public void addItemVenta(ItemVenta itemVenta) {
		this.itemVenta.add(itemVenta);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
