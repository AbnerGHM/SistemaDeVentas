package com.java.abner.abarrotes.hernandez.app.domain.models;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

@Component
public class Resume {

private String nombreProducto;

private Long cantidad;
@Column(columnDefinition = "Decimal(10,2)")
private Double total;
@Column(columnDefinition = "Decimal(10,2)")
private Double ganancia;

private Integer cantidadDisponible;

public Resume() {
	
	// TODO Auto-generated constructor stub
}

public Resume(String nombreProducto, Long cantidad, Double total, Double ganancia, Integer cantidadDisponible) {
	
	this.nombreProducto = nombreProducto;
	this.cantidad = cantidad;
	this.total = total;
	this.ganancia = ganancia;
	this.cantidadDisponible = cantidadDisponible;
	
}

public String getNombreProducto() {
	return nombreProducto;
}

public void setNombreProducto(String nombreProducto) {
	this.nombreProducto = nombreProducto;
}

public Long getCantidad() {
	return cantidad;
}

public void setCantidad(Long cantidad) {
	this.cantidad = cantidad;
}

public Double getTotal() {
	return total;
}

public void setTotal(Double total) {
	this.total = total;
}

public Double getGanancia() {
	return ganancia;
}

public void setGanancia(Double ganancia) {
	this.ganancia = ganancia;
}

public Integer getCantidadDisponible() {
	return cantidadDisponible;
}

public void setCantidadDisponible(Integer cantidadDisponible) {
	this.cantidadDisponible = cantidadDisponible;
}





	
}
