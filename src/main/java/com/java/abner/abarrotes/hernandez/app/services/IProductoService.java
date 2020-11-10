package com.java.abner.abarrotes.hernandez.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Page<Producto> findAll(Pageable pageable);
	
	public void save(Producto producto);
	
	public Producto findOne(String codigo); 
	
	public void  delete (String codigo);
	
	public List<Producto> findByNombre(String term);
	
}
