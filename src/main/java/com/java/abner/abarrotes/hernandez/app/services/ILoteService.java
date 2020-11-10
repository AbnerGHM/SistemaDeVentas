package com.java.abner.abarrotes.hernandez.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.abner.abarrotes.hernandez.app.domain.models.Lote;

public interface ILoteService {
	
	public List<Lote> findAll();
	
	public Page<Lote> findAll(Pageable pageable);
	
	public void save(Lote lote);
	
	public Lote findOne(String noLote); 
	
	public void  delete (String noLote);
	

}
