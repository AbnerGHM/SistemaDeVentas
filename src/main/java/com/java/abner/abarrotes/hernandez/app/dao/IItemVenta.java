package com.java.abner.abarrotes.hernandez.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.java.abner.abarrotes.hernandez.app.domain.models.ItemVenta;

public interface IItemVenta extends PagingAndSortingRepository<ItemVenta, Long> {
	
	@Query("SELECT I FROM ItemVenta I WHERE I.venta.id = ?1")
	  List<ItemVenta> findItemsByIdVenta(Long id);
	

}
