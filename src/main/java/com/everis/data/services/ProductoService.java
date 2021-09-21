package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRepository;

@Service
public class ProductoService {

	private final ProductoRepository pR;
	
	public ProductoService(ProductoRepository productoRepository) {
		
		this.pR = productoRepository;
	}
	
	
	
	public List<Producto> findAllProductos() {

		
		
		return pR.findAll();
	}

	public void modificarProducto(@Valid Producto productito) {
		
		
		pR.save(productito);
		
		
	}



	public void eliminarProducto(Long id) {
		pR.deleteById(id);
		
	}



	public Producto buscarproductito(Long id) {
		Optional<Producto> oProducto = pR.findById(id);
		
		if(oProducto.isPresent()) {
			return oProducto.get();
		}
		return null;
	}


	

	public void insertarProducto(@Valid Producto productito) {
		pR.save(productito);

		
	}
	
	
	

}
