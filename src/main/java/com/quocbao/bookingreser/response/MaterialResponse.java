package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Material;

import lombok.Setter;

@Setter
public class MaterialResponse {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("code")
	protected String code;

	@JsonProperty("name")
	protected String name;

	@JsonProperty("cost")
	protected float cost;
	
	@JsonProperty("quantity")
	private float quantity;

	@JsonProperty("stockend")
	protected float stockEnd;

	@JsonProperty("status")
	private String status;

	public MaterialResponse(Material material) {
		this.id = material.getId();
		this.code = material.getCode();
		this.name = material.getName();
		this.cost = material.getCost();
		this.quantity = material.getQuantity();
		this.stockEnd = material.getStockEnd();
		this.status = material.getStatus();
	}

	public List<MaterialResponse> materialResponses(List<Material> materials) {
		return materials.stream().map(MaterialResponse::new).toList();
	}

	public MaterialResponse() {

	}
}
