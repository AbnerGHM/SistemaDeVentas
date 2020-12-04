package com.java.abner.abarrotes.hernandez.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.abner.abarrotes.hernandez.app.dao.IItemVentaDao;
import com.java.abner.abarrotes.hernandez.app.dao.ILoteDao;
import com.java.abner.abarrotes.hernandez.app.domain.models.ItemVenta;
import com.java.abner.abarrotes.hernandez.app.domain.models.Lote;
import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;
import com.java.abner.abarrotes.hernandez.app.domain.models.Venta;
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

	@Autowired
	IItemVentaDao itemsVenta;

	@RequestMapping({ "", "/", "index" })
	public String index(Model model) {
		model.addAttribute("ventas", ventaService.findLast5());
		return "index";

	}

//	@RequestMapping("/gestion/add")
//	public String pageEliminar(Model model ) {
//		
//		
//		return "/gestion/add";
//	}

	@RequestMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto> cargarProductos(@RequestParam String term) {

		return productoService.findByNombre(term);
	}

	@RequestMapping(value = "/cargar-lotes/{term}", produces = { "application/json" })
	public @ResponseBody List<Lote> cargarLotes(@RequestParam Long term) {

		return loteDao.findByNoLoteLikeCodigo(term);
	}

	@RequestMapping(value = "/show-info/{id}", produces = { "application/json" })
	public @ResponseBody List<ItemVenta> mostrarInfo(@PathVariable(value = "id") Long id) {

		return itemsVenta.findItemsByIdVenta(id);

	}

	@PostMapping("/form")
	public String guardarVenta(  Venta venta, @RequestParam(name = "cantidad[]") Integer[] cantidad,
			@RequestParam(name = "item_id[]") Long[] itemId ,RedirectAttributes flash) {
		

		for (int i = 0; i < itemId.length; i++) {
			Producto producto = productoService.findOne(itemId[i]);
			ItemVenta itemVenta = new ItemVenta();
			if (cantidad[i]<=0) {
			flash.addFlashAttribute("error", "¡Error, no se ha logrado registrar la venta!");
			 return "redirect:/index";
			}
			
			itemVenta.setCantidad(cantidad[i]);
			itemVenta.setProducto(producto);
			itemVenta.setTotal(producto.getPrecio() * cantidad[i]);
			itemVenta.setGanancia(cantidad[i]*(producto.getPrecio()-producto.getPrecioU()));
			venta.addItemVenta(itemVenta);

			productoService.reducirMercancia(itemId[i], cantidad[i]);

		}

		venta.setTotal(venta.getItemVenta().stream().map(ItemVenta::getTotal).reduce((float) 0,
				(subtotal, element) -> subtotal + element));

		ventaService.save(venta);
		
		flash.addFlashAttribute("success", "¡Venta registrada exitosamente!");


	    return "redirect:/index";
		
	}



	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarVenta(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		
		
		Venta venta = ventaService.findOne(id);

		for (ItemVenta item : venta.getItemVenta()) {

			Producto producto = productoService.findOne(item.getProducto().getId());

			productoService.restaurarMercancia(producto.getId(), item.getCantidad());
		}
		
		ventaService.delete(id);
		 flash.addFlashAttribute("ventaEliminada", "¡Se ha eliminado la venta!, INVENTARIO ACTUALIZADO");
		return "redirect:/index";

	}
}
