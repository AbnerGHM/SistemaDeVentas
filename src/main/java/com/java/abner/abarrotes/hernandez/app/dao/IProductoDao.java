package com.java.abner.abarrotes.hernandez.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;
public interface IProductoDao extends PagingAndSortingRepository<Producto, Long> {

	@Query("select  p from Producto p where p.nombre LIKE %?1% AND p.onStock = true")
	public List<Producto> findByNombre(String nombre);
	
	@Query("select  p from Producto p where p.nombre LIKE %?1%")
	public List<Producto> findAllByNombre(String nombre);
	

}
