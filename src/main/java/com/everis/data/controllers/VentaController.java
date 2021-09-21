package com.everis.data.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.data.models.Venta;
import com.everis.data.services.ProductoService;
import com.everis.data.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	
	@Autowired
	private VentaService vS;
	
	@Autowired
	private ProductoService pS;
	

	@RequestMapping("")
	public String inicio(Model model) {
		model.addAttribute("lista_venta", vS.findAll());
		model.addAttribute("lista_productos", pS.findAllProductos());
		
		
		
		return "venta.jsp";
	}
	

	
	@RequestMapping("/crear")
	public String crearVenta(@Valid @ModelAttribute("venta") Venta venta) {
		//llamar a las validaciones
		
		vS.saveVenta(venta);

		return "login.jsp";
	}
	
}

