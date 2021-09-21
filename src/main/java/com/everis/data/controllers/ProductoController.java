package com.everis.data.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	private Integer suma = 0;
	public List<Producto> carrito = new ArrayList<Producto>();
	
	
	@Autowired
	private ProductoService pS;
	
	
	@RequestMapping("")
	public String index(@ModelAttribute("producto") Producto productito, Model model) {
		
		List<Producto> lista_productos = pS.findAllProductos();
		model.addAttribute("lista_productos", lista_productos);
		
		
		System.out.println("Works producto");
		return "producto.jsp";
	}
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("producto") Producto productito) {
		System.out.println("crear "+ productito);
	
		//    validacion      //
		
		
		
		//	   validacion      //
		
		pS.insertarProducto(productito);
		
		return "redirect:/producto";
		
	}
	
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id,Model model) {
		
		System.out.println("actualizar id: "+ id);
		
		Producto productito = pS.buscarproductito(id);
		model.addAttribute("producto",productito);
		
		return "editar_producto.jsp";
		}
	
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("producto") Producto productito) {
		
		
		
		
		//    validacion      //
		
		
		
		//	  validacion      //		
		
		
		pS.modificarProducto(productito);
		
		return "redirect:/producto";
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		
	System.out.println("Eliminar id de producto: "+ id);
	
	pS.eliminarProducto(id);
	return "redirect:/producto";
	}
	

	
	@RequestMapping(value= "/agregarCarro", method = RequestMethod.POST)
	public String agregarCarro(Model model, @RequestParam("id") Long id) {
		
		Producto prod = pS.buscarproductito(id);
		
		carrito.add(prod);
		suma += prod.getValorBase(); 
		System.out.println("precio " + suma);
		model.addAttribute("total", suma);
		model.addAttribute("carrito", carrito);
		
		
		
		return "resumen_compra.jsp";
	}
	
	
	@RequestMapping(value= "/eliminarCarro", method = RequestMethod.POST)
	public String eliminarCarro(Model model, @RequestParam("id") Long id) {
		model.addAttribute("total", suma);
		model.addAttribute("carrito", carrito);
		
		System.out.println(" lista" + carrito);
		Producto prod = pS.buscarproductito(id);
		int index = carrito.indexOf(prod);
		
		
		if(index != -1) {
			carrito.remove(index);
			suma -= prod.getValorBase(); 
		} else if(index == -1) {
			System.out.println("-1");
		}
		
		
		/*
		if(carrito.remove(prod)) {
			System.out.println("hola");
			
			


		}*/

		//System.out.println("no se encontró el producto");
		
		
		return "resumen_compra.jsp";
	}
	
	
	
}
