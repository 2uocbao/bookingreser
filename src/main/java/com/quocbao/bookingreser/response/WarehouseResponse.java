package com.quocbao.bookingreser.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Warehouse;

import lombok.Setter;

@Setter
public class WarehouseResponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("material_id")
	private Long materialId;
	
	@JsonProperty("company_id")
	private Long companyId;
	
	public WarehouseResponse(Warehouse warehouse) {
		this.id = warehouse.getId();
		this.materialId = warehouse.getMaterial().getId();
		this.companyId = warehouse.getCompany().getId();
	}
}
