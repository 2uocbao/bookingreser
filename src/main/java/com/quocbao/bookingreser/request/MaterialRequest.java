package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class MaterialRequest {

	@JsonProperty("companyId")
	public Long companyId;

	@JsonProperty("code")
	public String code;

	@JsonProperty("name")
	public String name;

	@JsonProperty("cost")
	public float cost;

	@JsonProperty("stockend")
	public float stockEnd;
}
