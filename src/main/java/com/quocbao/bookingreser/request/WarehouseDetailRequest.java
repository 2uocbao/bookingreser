package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WarehouseDetailRequest {

	@JsonProperty("cost")
	private float cost;
	
	@JsonProperty("vat")
	private float vat;
	
	@JsonProperty("quantity")
	private float quantity;
	
	@JsonProperty("totalamount")
	private float totalAmount;
}
