package com.java.abner.abarrotes.hernandez.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.abner.abarrotes.hernandez.app.dao.IProductoDao;
import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;

@Service
public class ProductoServiceImpl  implements IProductoService{
	
	@Autowired
	IProductoDao productoDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Producto producto) {
		productoDao.save(producto);
		
	}

	@Override
	public Producto findOne(String codigo) {
		// TODO Auto-generated method stub
		return productoDao.findById(codigo).get();
	}

	@Override
	public void delete(String codigo) {
		productoDao.delete( findOne(codigo) );
		
	}

	@Override
	public List<Producto> findByNombre(String term) {
		// TODO Auto-generated method stub
		return productoDao.findByNombre(term);
	}
	
	

}
