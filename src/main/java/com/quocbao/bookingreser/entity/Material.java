package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.quocbao.bookingreser.request.MaterialRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "material")
@DynamicUpdate
@NoArgsConstructor
public class Material implements Serializable {

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

	// relationship

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	@ManyToMany
	@JoinTable(name = "type_shared", joinColumns = @JoinColumn(name = "material_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
	private Set<Types> types = new HashSet<>();

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
