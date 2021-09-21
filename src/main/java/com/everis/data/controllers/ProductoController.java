package com.everis.data.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	//private int sumPos = 0; por idea de guardar por posicion en la lista carrito
	//private List<Producto> carrito = new ArrayList<Producto>(); posible lista para historial de compra
	Map<String, Integer> arrayProductos = new HashMap<String, Integer>(); //Array bidimensional al no resultarme listas por ningún lado 
	
	
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
	public String agregarCarro(Model model, @RequestParam("nombre") String nombresito, 
											@RequestParam("valor Base") Integer valorB) {
		
		arrayProductos.put(nombresito, valorB);
		suma += valorB;
		/*
		carrito.add(pS.buscarproductito(id));
		suma += pS.buscarproductito(id).getValorBase();
		 */
		
		model.addAttribute("Precio_Total", suma);
		model.addAttribute("carrito", arrayProductos);
		System.out.println("Precio: " + suma +" Nombre: " + nombresito);
		return "resumen_compra.jsp";
	}
	
	
	@RequestMapping(value= "/eliminarCarro", method = RequestMethod.POST)
	public String eliminarCarro(Model model, @RequestParam("nombre") String nombresito,
											@RequestParam("valor Base") Integer valorB) {


		arrayProductos.remove(nombresito);
		suma -= valorB;
		model.addAttribute("Precio_Total", suma);
		model.addAttribute("carrito", arrayProductos);
		System.out.println(" nombre: "+ nombresito +" de precio " + valorB );
	

		/* intento 3
		for (Producto prod: carrito) {
			
			if(prod.getId() == id){	
				suma -= prod.getValorBase();
				carrito.remove(sumPos);	
				
			}
			sumPos ++;
		}  */
		// intento 2
		//Producto prod2 = pS.buscarproductito(id);
		//int index = carrito.indexOf(pS.buscarproductito(id));
		
		
		/* intento 1
		if(carrito.remove(prod)) {
			System.out.println("hola");
			
			


		}*/

		//System.out.println("no se encontró el producto");
		
		
		return "resumen_compra.jsp";
	}
	
	
	
	
	
}
