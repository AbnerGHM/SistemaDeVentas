package com.java.abner.abarrotes.hernandez.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;
public interface IProductoDao extends PagingAndSortingRepository<Producto, String> {

	@Query("select  p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String codigo);
	

}
