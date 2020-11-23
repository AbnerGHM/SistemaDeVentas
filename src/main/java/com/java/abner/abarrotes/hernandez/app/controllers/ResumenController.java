package com.java.abner.abarrotes.hernandez.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.java.abner.abarrotes.hernandez.app.domain.models.ItemVenta;
import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;
import com.java.abner.abarrotes.hernandez.app.domain.models.Resume;
import com.java.abner.abarrotes.hernandez.app.services.IProductoService;

@Controller

public class ResumenController {

	@Autowired
	IItemVentaDao itemVentaDao;

	@RequestMapping("resumen")
	public String gestionar(Model model) {
		Date hoy = new Date();
		model.addAttribute("ventas", itemVentaDao.resumirVentas(hoy ,hoy));
		
		Float total = 0f;
		for (Resume item : itemVentaDao.resumirVentas(hoy, hoy)) {
			total += item.getSubtotal();
		}
		
	    SimpleDateFormat  formater = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy", new Locale("es_ES"));
	    
	    String fechaInicial = formater.format(hoy);
	    String fechaFinal = formater.format(hoy);
	   
	    if (fechaInicial.equalsIgnoreCase(fechaFinal)) {
	    	model.addAttribute("textoConsulta", "Ganancia totales del dia de hoy:");
		}else {
		model.addAttribute("textoConsulta", "Ganancia total del periodo " + fechaInicial + " al " + fechaFinal + ":" );
		}
		model.addAttribute("total", String.format("%.2f", total));
		return "resumen";
	}

	@RequestMapping(value = "/form-resumen", method = RequestMethod.GET)
	
	public String visualizarRangoDeVentas(Model model,
			@RequestParam(name = "inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
			@RequestParam(name = "fin") @DateTimeFormat(pattern ="yyyy-MM-dd") Date fin) {

		model.addAttribute("ventas", itemVentaDao.resumirVentas(inicio, fin));
		
		Float total = 0f;
		for (Resume item : itemVentaDao.resumirVentas(inicio, fin)) {
			total += item.getSubtotal();
		}
		
	    SimpleDateFormat  formater = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy", new Locale("es_ES"));
	    
	    String fechaInicial = formater.format(inicio);
	    String fechaFinal = formater.format(fin);
		model.addAttribute("textoConsulta", "Ganancia total del periodo " + fechaInicial + " al " + fechaFinal );
		
		model.addAttribute("total", String.format("%.2f", total));
		
		return "resumen";

	}
}
