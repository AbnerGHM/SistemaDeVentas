package com.java.abner.abarrotes.hernandez.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.java.abner.abarrotes.hernandez.app.domain.models.Lote;

public interface ILoteDao extends PagingAndSortingRepository<Lote, String>  {

	@Query("SELECT l FROM Lote l  WHERE l.producto.codigo = ?1")
	List<Lote> findByNoLoteLikeCodigo(String codigo);
	
}
