package com.quocbao.bookingreser.request;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MaterialRequest {

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("cost")
	private float cost;
	
	@JsonProperty("quantity")
	private float quantity;
	
	@JsonProperty("stockend")
	private float stockEnd;
	
	@JsonProperty("type")
	private Set<TypeRequest> typeRequest;
}
