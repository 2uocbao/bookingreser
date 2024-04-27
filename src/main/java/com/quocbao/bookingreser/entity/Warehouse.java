package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.quocbao.bookingreser.request.WarehouseRequest;
import com.quocbao.bookingreser.util.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "warehouse")
@DynamicUpdate
@NoArgsConstructor
public class Warehouse implements Serializable {

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

	@Column(name = "unit")
	private String unit;

	@Column(name = "status")
	private String status;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Timestamp createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// relationship
	@OneToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "material_id", referencedColumnName = "id")
	private Material material;

	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = true, updatable = true)
	private Employee employee;

	public Warehouse(WarehouseRequest warehouseRequest, Material material, Employee employee) {
		this.material = material;
		this.employee = employee;
		this.cost = warehouseRequest.getCost();
		this.vat = warehouseRequest.getVat();
		this.quantity = warehouseRequest.getQuantity();
		this.totalAmount = (cost * quantity * vat) + (cost * quantity);
		this.status = Status.UNCONFIRMED.toString();
		this.unit = warehouseRequest.getUnit();
	}

	public void setWarehouse(WarehouseRequest warehouseRequest) {
		this.cost = warehouseRequest.getCost();
		this.vat = warehouseRequest.getVat();
		this.quantity = warehouseRequest.getQuantity();
		this.totalAmount = (cost * quantity * vat) + (cost * quantity);
	}
}
