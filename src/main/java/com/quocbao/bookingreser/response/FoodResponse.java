package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.entity.Types;

import lombok.Setter;

@Setter
public class FoodResponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	protected String name;

	@JsonProperty("price")
	protected float price;

	@JsonProperty("image")
	protected String image;

	@JsonProperty("type")
	protected List<String> types;

	@JsonProperty("status")
	private String status;

	@JsonProperty("FoodDetail")
	private List<FoodDetailResponse> foodDetailResponses;

	public FoodResponse() {

	}

	public FoodResponse(Food food) {
		this.id = food.getId();
		this.name = food.getName();
		this.image = food.getImage();
		this.price = food.getPrice();
		this.status = food.getStatus();
		this.types = food.getTypes().stream().map(Types::getName).toList();
		this.foodDetailResponses = new FoodDetailResponse().foodDetailResponses(food.getFoodDetails());
	}

	public List<FoodResponse> foodResponses(List<Food> foods) {
		return foods.stream().map(FoodResponse::new).toList();
	}
}
