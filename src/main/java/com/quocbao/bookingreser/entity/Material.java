package com.quocbao.bookingreser.entity;

import java.io.Serializable;

import com.quocbao.bookingreser.request.MaterialRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "material")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Material implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private float cost;
	
	@Column(name = "quantity")
	private float quantity;
	
	@Column(name = "stock_end")
	private float stockEnd;
	
	@Column(name = "status")
	private int status;
	
	//relationship
	
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	public Material(MaterialRequest materialRequest, Company company) {
		this.company = company;
		this.code = materialRequest.getCode();
		this.name = materialRequest.getName();
		this.cost = materialRequest.getCost();
		this.quantity = materialRequest.getQuantity();
		this.stockEnd = materialRequest.getStockEnd();
	}
	
	public void setMaterial(MaterialRequest materialRequest) {
		this.code = materialRequest.getCode();
		this.name = materialRequest.getName();
		this.cost = materialRequest.getCost();
		this.quantity = materialRequest.getQuantity();
		this.stockEnd = materialRequest.getStockEnd();
	}
}
