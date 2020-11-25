package com.java.abner.abarrotes.hernandez.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.java.abner.abarrotes.hernandez.app.domain.models.ItemVenta;
import com.java.abner.abarrotes.hernandez.app.domain.models.Resume;

public interface IItemVentaDao extends PagingAndSortingRepository<ItemVenta, Long> {
	
	@Query(value="SELECT new com.java.abner.abarrotes.hernandez.app.domain.models.Resume(p.nombre, SUM(a.cantidad), SUM(a.total), SUM(a.ganancia ), p.cantidad) FROM ItemVenta a JOIN Producto p ON p.id = a.producto.id JOIN Venta v ON v.id = a.venta.id AND v.fecha BETWEEN ?1 AND ?2 GROUP BY p.id")
	List<Resume> resumirVentas(Date inicio , Date fin);
	
	@Query("SELECT I FROM ItemVenta I WHERE I.venta.id = ?1")
	  List<ItemVenta> findItemsByIdVenta(Long id);
	
//	@Query(value="SELECT new com.java.abner.abarrotes.hernandez.app.domain.models.Resume"
//			+ "(p.nombre, SUM( a.cantidad ), p.precioU, p.precio,a.total,a.ganancia,p.cantidad)  FROM  ItemVenta a  JOIN Producto p ON a.producto.id = p.id JOIN Venta v ON v.id = a.venta.id AND v.fecha BETWEEN ?1 AND ?2  GROUP BY a.producto.id")
//	List<Resume> resumirVentas(Date inicio , Date fin);

}
