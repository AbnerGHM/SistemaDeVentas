package com.java.abner.abarrotes.hernandez.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;
import com.java.abner.abarrotes.hernandez.app.services.IProductoService;

@Controller
@RequestMapping("/gestion")
public class GestionController {

	@Autowired
	IProductoService productoService;
	
	@RequestMapping(value = "/cargar-productos/{term}" , produces = { "application/json" })
	public @ResponseBody  List<Producto> getProductos(@RequestParam String term){
		
		return productoService.findByNombre(term);
	}

	
	@RequestMapping(value="/add")
	public String gestionar(Model model) {
		
		model.addAttribute("productos", productoService.findAll());
		return "gestion/add";
	}
}
