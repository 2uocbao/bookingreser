package com.quocbao.bookingreser.request;

import java.util.List;

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
	
	@JsonProperty("foodDetails")
	public List<FoodDetailRequest> foodDetailRequests;
}
