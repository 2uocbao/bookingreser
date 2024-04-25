package com.quocbao.bookingreser.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class FoodRequest {
	
	@JsonProperty("id")
	protected Long id;

	@JsonProperty("companyId")
	protected Long companyId;

	@JsonProperty("name")
	protected String name;

	@JsonProperty("price")
	protected float price;

	@JsonProperty("image")
	protected String image;

	@JsonProperty("type")
	protected List<String> types;
	
	@JsonProperty("status")
	protected String status;
	
}
