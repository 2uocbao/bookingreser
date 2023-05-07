package com.quocbao.bookingreser.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.request.MaterialRequest;

import lombok.Setter;

@Setter
public class MaterialResponse extends MaterialRequest{

	@JsonProperty("id")
	private Long id;
	
	public MaterialResponse(Material material) {
		this.id = material.getId();
		this.code = material.getCode();
		this.name = material.getName();
		this.cost = material.getCost();
		this.quantity = material.getQuantity();
		this.stockEnd = material.getStockEnd();
	}
}
