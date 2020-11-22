package com.java.abner.abarrotes.hernandez.app.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.abner.abarrotes.hernandez.app.dao.IItemVentaDao;
import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;
import com.java.abner.abarrotes.hernandez.app.services.IProductoService;

@Controller

public class ResumenController {

	@Autowired
	IItemVentaDao itemVentaDao;

	@RequestMapping("resumen")
	public String gestionar(Model model) {

		model.addAttribute("ventas", itemVentaDao.resumirVentas(new Date(), new Date()));
		return "resumen";
	}

	@RequestMapping(value = "/form-resumen", method = RequestMethod.GET)
	
	public String visualizarRangoDeVentas(Model model,
			@RequestParam(name = "inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
			@RequestParam(name = "fin") @DateTimeFormat(pattern ="yyyy-MM-dd") Date fin) {

		model.addAttribute("ventas", itemVentaDao.resumirVentas(inicio, fin));
		return "resumen";

	}
}
