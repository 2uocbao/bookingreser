package com.quocbao.bookingreser.response;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Warehouse;

import lombok.Setter;

@Setter
public class WarehouseResponse {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("material")
	public MaterialResponse materialId;

	@JsonProperty("employeeId")
	public EmployeeResponse employeeId;

	@JsonProperty("cost")
	public float cost;

	@JsonProperty("vat")
	public float vat;

	@JsonProperty("quantity")
	public float quantity;

	@JsonProperty("total_amount")
	private float totalAmount;

	@JsonProperty("status")
	private String status;

	@JsonProperty("created_at")
	private Timestamp createdAt;

	@JsonProperty("updated_at")
	private Timestamp updatedAt;

	public WarehouseResponse(Warehouse warehouse) {
		this.id = warehouse.getId();
		this.materialId = new MaterialResponse(warehouse.getMaterial());
		this.employeeId = new EmployeeResponse(warehouse.getEmployee());
		this.cost = warehouse.getCost();
		this.quantity = warehouse.getQuantity();
		this.vat = warehouse.getVat();
		this.totalAmount = warehouse.getTotalAmount();
		this.status = warehouse.getStatus();
		this.createdAt = warehouse.getCreatedAt();
		this.updatedAt = warehouse.getUpdatedAt();
	}
}
