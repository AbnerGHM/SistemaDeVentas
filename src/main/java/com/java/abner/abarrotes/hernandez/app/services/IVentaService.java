package com.java.abner.abarrotes.hernandez.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.abner.abarrotes.hernandez.app.domain.models.ItemVenta;
import com.java.abner.abarrotes.hernandez.app.domain.models.Venta;

public interface IVentaService {

	
public List<Venta> findAll();
	
	public Page<Venta> findAll(Pageable pageable);
	
	public void save(Venta venta);
	
	public Venta findOne(Long id); 
	
	public void  delete (Long id);
	
//	public List<ItemVenta> itemsVenta(Long id);
	
}
