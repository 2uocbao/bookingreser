package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class WarehouseRequest {

	@JsonProperty("companyId")
	public Long companyId;
	
	@JsonProperty("materialId")
	public Long materialId;
}
