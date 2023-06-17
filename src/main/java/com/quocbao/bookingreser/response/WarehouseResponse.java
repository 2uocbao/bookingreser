package com.quocbao.bookingreser.response;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.request.WarehouseRequest;

import lombok.Setter;

@Setter
public class WarehouseResponse extends WarehouseRequest{

	@JsonProperty("id")
	private Long id;

	@JsonProperty("material")
	private MaterialResponse material;

	@JsonProperty("employeeId")
	private EmployeeResponse employee;

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
		this.materialId = warehouse.getMaterial().getName();
		this.employeeId = warehouse.getEmployee().getFirstName() + warehouse.getEmployee().getLastName();
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
