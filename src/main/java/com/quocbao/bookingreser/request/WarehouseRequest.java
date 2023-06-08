package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class WarehouseRequest {

	@JsonProperty("materialId")
	private Long materialId;

	@JsonProperty("employeeId")
	private Long employeeId;

	@JsonProperty("cost")
	private float cost;

	@JsonProperty("vat")
	private float vat;

	@JsonProperty("quantity")
	private float quantity;

	@JsonProperty("unit")
	private String unit;
}
