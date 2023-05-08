package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.quocbao.bookingreser.request.WarehouseDetailRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "warehouse_detail")
@DynamicUpdate
public class WarehouseDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cost")
	private float cost;
	
	@Column(name = "vat")
	private float vat;
	
	@Column(name = "quantity")
	private float quantity;
	
	@Column(name = "total_amount")
	private float totalAmount;
	
	@Column(name = "status")
	private int status;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Timestamp createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	//relationship
	
	@ManyToOne
	@JoinColumn(name = "warehouse_id", referencedColumnName = "id")
	private Warehouse warehouse;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;
	
	public WarehouseDetail(WarehouseDetailRequest warehouseDetailRequest, Warehouse warehouse, Employee employee) {
		this.warehouse = warehouse;
		this.employee = employee;
		this.cost = warehouseDetailRequest.getCost();
		this.vat = warehouseDetailRequest.getVat();
		this.quantity = warehouseDetailRequest.getQuantity();
	}
}
