package com.java.abner.abarrotes.hernandez.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.abner.abarrotes.hernandez.app.dao.IItemVentaDao;
import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;
import com.java.abner.abarrotes.hernandez.app.services.IProductoService;

@Controller
public class CrudController {

	@Autowired
	IProductoService productoService;

	@Autowired
	IItemVentaDao itemVentaDao;

	@RequestMapping("update")
	public String showUpdatePage(Model model) {
		model.addAttribute("producto", new Producto());
		return "update";
	}
	
	@RequestMapping(value = "/cargar-full-productos/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto> cargarProductos(@RequestParam String term) {

		return productoService.findAllByNombre(term);
	}

	@PostMapping(value = "/crud", params = { "save" })
	public String save(Producto producto, Model model, RedirectAttributes flash) {

		if (productoService.findAllByNombre(producto.getNombre().trim()).size() < 1
				&& (producto.getId() == null || producto.getId() <= 0)) {

			if(producto.getNombre().matches("[A-Za-z0-9\\s&]*")) {
			productoService.save(producto);

			flash.addFlashAttribute("creado", "¡Producto creado con exito!");
			}else {
			flash.addFlashAttribute("badRegex", "¡El nombre del producto solo puede contener letras, numeros y el simbolo &!");	
			}
			return "redirect:update";
		} else if (producto.getId() > 0 && producto.getId() != null) {
			
			Producto productoU = productoService.findOne(producto.getId());
			productoU.setNombre(producto.getNombre());
			productoU.setCantidad(producto.getCantidad());
			productoU.setPrecio(producto.getPrecio());
			productoU.setPrecioU(producto.getPrecioU());
			productoU.setOnStock(true);
			productoService.save(productoU);
			flash.addFlashAttribute("existe", "¡Se ha actualizado el producto " + producto.getNombre() + "!");
			return "redirect:update";
		}else {
			flash.addFlashAttribute("error", "¡No puedes crear un producto con el mismo nombre! Utiliza el boton Actualizar.");
		return "redirect:update";
		}

	}

	@PostMapping(value = "/crud", params = { "delete" })
	public String delete(Producto producto, Model model, RedirectAttributes flash) {
		
		if (producto.getId() > 0 && producto.getId() != null) {
			producto.setOnStock(false);
//			Producto productoU = productoService.findOne(producto.getId());
//			productoU.setOnStock(false);
			productoService.save(producto);
			flash.addFlashAttribute("eliminado", "¡Se ha ELIMINADO el producto " + producto.getNombre() + "!");
			
		}
		return "redirect:update";
	}
//	@PostMapping(value="/crud" ,  params = {"update"})
//	public String update(Producto producto, Model model, RedirectAttributes flash) {
//		
//	return "redirect:update";
//	}
}
