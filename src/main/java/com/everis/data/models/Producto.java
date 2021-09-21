package com.everis.data.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String codigo;
	private Integer valorBase;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt; 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	
//contructores
	
	public Producto() {
		super();
	}




	public Producto(String nombre, String codigo, Integer valorBase) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.valorBase = valorBase;
	}


	//getters y setters

	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	public Integer getValorBase() {
		return valorBase;
	}




	public void setValorBase(Integer valorBase) {
		this.valorBase = valorBase;
	}

	
	@PrePersist 
	protected void onCreate(){
	this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	}
	
	
	
	
	
	
}
