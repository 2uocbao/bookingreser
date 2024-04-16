package com.quocbao.bookingreser.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicUpdate;

import com.quocbao.bookingreser.request.MaterialRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private String status;

	// relationship
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	public Material(MaterialRequest materialRequest) {
		this.id = materialRequest.getId();
		this.code = materialRequest.getCode();
		this.name = materialRequest.getName();
		this.cost = materialRequest.getCost();
		this.stockEnd = materialRequest.getStockEnd();
		this.status = materialRequest.getStatus();
	}

	public Material(Long id, String code, String name, String status) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.status = status;
	}
}
