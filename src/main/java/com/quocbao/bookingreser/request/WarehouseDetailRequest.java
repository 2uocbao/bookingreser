package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class WarehouseDetailRequest {

	@JsonProperty("cost")
	public float cost;
	
	@JsonProperty("vat")
	public float vat;
	
	@JsonProperty("quantity")
	public float quantity;
}
