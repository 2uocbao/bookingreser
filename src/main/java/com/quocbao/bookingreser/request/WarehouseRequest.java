package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class WarehouseRequest {

	@JsonProperty("materialId")
	protected Long materialId;

	@JsonProperty("employeeId")
	protected String employeeId;

	@JsonProperty("cost")
	protected float cost;

	@JsonProperty("vat")
	protected float vat;

	@JsonProperty("quantity")
	protected float quantity;

	@JsonProperty("unit")
	protected String unit;
}
