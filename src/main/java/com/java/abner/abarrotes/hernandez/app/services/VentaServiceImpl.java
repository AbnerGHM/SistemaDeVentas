package com.java.abner.abarrotes.hernandez.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.abner.abarrotes.hernandez.app.dao.IVentaDao;
import com.java.abner.abarrotes.hernandez.app.domain.models.ItemVenta;
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
	@Transactional(readOnly = true)
	public Page<Venta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void save(Venta venta) {
		
		ventaDao.save(venta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Venta findOne(Long id) {
		// TODO Auto-generated method stub
		return ventaDao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		ventaDao.deleteById(id);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> findLast5() {
		// TODO Auto-generated method stub
		return (List<Venta>) ventaDao.findTop5ByOrderByIdDesc();
	}

//	@Override
//	public List<ItemVenta> itemsVenta(Long id) {
//		// TODO Auto-generated method stub
//		return ;
//	}

}
