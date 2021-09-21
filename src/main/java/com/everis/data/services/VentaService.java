package com.everis.data.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Venta;
import com.everis.data.repositories.VentaRepository;

@Service
public class VentaService {
	
	@Autowired
	private VentaRepository vR;

	public List<Venta> findAll() {
		return vR.findAll();
	}

	public void saveVenta(@Valid Venta venta) {
		vR.save(venta);
		
		
		
	}
	


//No lo encuentro necesario para el manejo de el orden de compra como un carrito simple

	
	
	

}
