package com.everis.data.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Venta;
import com.everis.data.services.VentaService;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
	


	
	
}
