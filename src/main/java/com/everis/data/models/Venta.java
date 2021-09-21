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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ventas")
public class Venta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String valorTotal;
 //nombre de la persona a cargo de realizar la venta
	
	@Column(updatable=false)
	@CreationTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt; 
	
	@UpdateTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
//contructores

	

	public Venta() {
		super();
	}

	public Venta(String valorTotal) {
		super();
		this.valorTotal = valorTotal;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}




	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
		
	


	

}
