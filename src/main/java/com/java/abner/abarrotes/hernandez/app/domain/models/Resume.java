package com.java.abner.abarrotes.hernandez.app.domain.models;

import org.springframework.stereotype.Component;

@Component
public class Resume {

	private String nombreProducto;
	private Long suma;

	public Resume() {

	}

	public Resume(String nombreProducto, Long suma) {
		
		this.setNombreProducto(nombreProducto);
		this.suma = suma;
	}



	public Long getSuma() {
		return suma;
	}

	public void setSuma(Long suma) {
		this.suma = suma;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	
}
