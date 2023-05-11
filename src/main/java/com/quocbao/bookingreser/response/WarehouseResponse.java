package com.quocbao.bookingreser.response;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.request.WarehouseRequest;

import lombok.Setter;

@Setter
public class WarehouseResponse extends WarehouseRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("material_id")
	private Long warehouseId;
	
	@JsonProperty("employee_id")
	private Long employeeId;
	
	@JsonProperty("total_amount")
	private float totalAmount;
	
	@JsonProperty("status")
	private int status;
	
	@JsonProperty("created_at")
	private Timestamp createdAt;
	
	@JsonProperty("updated_at")
	private Timestamp updatedAt;
	
	public WarehouseResponse(Warehouse warehouseDetail) {
		this.id = warehouseDetail.getId();
		this.employeeId = warehouseDetail.getEmployee().getId();
		this.cost = warehouseDetail.getCost();
		this.quantity = warehouseDetail.getQuantity();
		this.vat = warehouseDetail.getVat();
		this.totalAmount = warehouseDetail.getTotalAmount();
		this.status = warehouseDetail.getStatus();
		this.createdAt = warehouseDetail.getCreatedAt();
		this.updatedAt = warehouseDetail.getUpdatedAt();
	}
}
