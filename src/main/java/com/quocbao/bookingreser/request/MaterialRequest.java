package com.quocbao.bookingreser.request;

import java.util.Set;

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
	
	@JsonProperty("quantity")
	public float quantity;
	
	@JsonProperty("stockend")
	public float stockEnd;
	
	@JsonProperty("type")
	public Set<TypeRequest> typeRequest;
}
