package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class FoodDetailRequest {
	
	@JsonProperty("id")
	protected Long id;

	@JsonProperty("materialId")
	protected Long materialId;

	@JsonProperty("quantity")
	protected float quantity;
}
