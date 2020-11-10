package com.java.abner.abarrotes.hernandez.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.abner.abarrotes.hernandez.app.dao.ILoteDao;
import com.java.abner.abarrotes.hernandez.app.domain.models.Lote;
import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;
import com.java.abner.abarrotes.hernandez.app.services.ILoteService;
import com.java.abner.abarrotes.hernandez.app.services.IProductoService;
import com.java.abner.abarrotes.hernandez.app.services.IVentaService;

@Controller
public class IndexController {
	@Autowired
	IVentaService ventaService;
	@Autowired
	IProductoService productoService;
	
	@Autowired
	ILoteDao loteDao;

	
	@RequestMapping({"","/","index"})	
	public String index( Model model) {
		model.addAttribute("ventas", ventaService.findAll() );
		model.addAttribute("lotes", loteDao.findByNoLoteLikeCodigo("A01"));
		return "index";
		
		
	}
	
	@RequestMapping(value = "/cargar-productos/{term}" , produces = {"application/json"})
	public @ResponseBody List<Producto> cargarProductos(@RequestParam String term){
		
		return productoService.findByNombre(term);
	}
	
	@RequestMapping(value = "/cargar-lotes/{term}", produces  = {"application/json"})
	public  @ResponseBody List<Lote> cargarLotes(@RequestParam String term){
		
		return loteDao.findByNoLoteLikeCodigo(term);
	}
	
	
}
