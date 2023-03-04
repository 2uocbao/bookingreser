package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FoodRequest {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("price")
	private float price;
	
	@JsonProperty("image")
	private String image;
}
