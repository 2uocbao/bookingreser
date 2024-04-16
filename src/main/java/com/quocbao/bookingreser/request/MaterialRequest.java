package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class MaterialRequest {
	
	@JsonProperty("id")
	protected Long id;

	@JsonProperty("companyId")
	protected Long companyId;

	@JsonProperty("code")
	protected String code;

	@JsonProperty("name")
	protected String name;

	@JsonProperty("cost")
	protected float cost;

	@JsonProperty("stockend")
	protected float stockEnd;
	
	@JsonProperty("quantity")
	protected float quantity;
	
	@JsonProperty("status")
	protected String status;
}
