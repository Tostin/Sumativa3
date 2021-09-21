package com.everis.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
	

}
