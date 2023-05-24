package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class FoodDetailRequest {
	
	@JsonProperty("materialId")
	public Long materialId;

	@JsonProperty("quantity")
	public float quantity;
}
