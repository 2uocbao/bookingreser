package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class FoodRequest {
	
	@JsonProperty("companyId")
	public Long companyId;

	@JsonProperty("name")
	public String name;
	
	@JsonProperty("price")
	public float price;
	
	@JsonProperty("image")
	public String image;
}
