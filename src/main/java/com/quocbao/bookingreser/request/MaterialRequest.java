package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class MaterialRequest {

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
}
