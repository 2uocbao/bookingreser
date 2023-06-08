package com.quocbao.bookingreser.response;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Warehouse;

import lombok.Setter;

@Setter
public class WarehouseResponse {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("material")
	private MaterialResponse materialId;

	@JsonProperty("employeeId")
	private EmployeeResponse employeeId;

	@JsonProperty("cost")
	private float cost;

	@JsonProperty("vat")
	private float vat;

	@JsonProperty("quantity")
	private float quantity;

	@JsonProperty("total_amount")
	private float totalAmount;

	@JsonProperty("unit")
	private String unit;

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
		this.unit = warehouse.getUnit();
		this.status = warehouse.getStatus();
		this.createdAt = warehouse.getCreatedAt();
		this.updatedAt = warehouse.getUpdatedAt();
	}

	public List<WarehouseResponse> warehouseResponses(List<Warehouse> warehouses) {
		return warehouses.stream().map(WarehouseResponse::new).toList();
	}

	public WarehouseResponse() {

	}
}
