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
	private MaterialResponse materialResponse;

	@JsonProperty("employeeId")
	private EmployeeResponse employeeResponse;

	@JsonProperty("vat")
	protected float vat;
	
	@JsonProperty("cost")
	protected float cost;
	
	@JsonProperty("quantity")
	protected float quantity;

	@JsonProperty("total_amount")
	private float totalAmount;
	
	@JsonProperty("unit")
	protected String unit;

	@JsonProperty("status")
	private String status;

	@JsonProperty("created_at")
	private Timestamp createdAt;

	@JsonProperty("updated_at")
	private Timestamp updatedAt;

	public WarehouseResponse(Warehouse warehouse) {
		this.id = warehouse.getId();
		this.materialResponse = new MaterialResponse(warehouse.getMaterial());
		this.employeeResponse = new EmployeeResponse(warehouse.getEmployee());
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
