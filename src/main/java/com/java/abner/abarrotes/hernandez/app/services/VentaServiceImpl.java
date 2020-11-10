package com.java.abner.abarrotes.hernandez.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.abner.abarrotes.hernandez.app.dao.IVentaDao;
import com.java.abner.abarrotes.hernandez.app.domain.models.Venta;

@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	IVentaDao ventaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	public Page<Venta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Venta venta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venta findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
