package com.java.abner.abarrotes.hernandez.app.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.java.abner.abarrotes.hernandez.app.domain.models.Venta;

public interface IVentaDao  extends PagingAndSortingRepository<Venta,Long>{

	
	public List<Venta> findTop5ByOrderByIdDesc();
}
