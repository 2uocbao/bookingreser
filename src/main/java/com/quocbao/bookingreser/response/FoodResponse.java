package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Food;

import lombok.Setter;

@Setter
public class FoodResponse {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("companyId")
	public Long companyId;

	@JsonProperty("name")
	public String name;

	@JsonProperty("price")
	public float price;

	@JsonProperty("image")
	public String image;

	@JsonProperty("status")
	private String status;

	@JsonProperty("FoodDetail")
	private List<FoodDetailResponse> foodDetailResponses;

	public FoodResponse() {

	}

	public FoodResponse(Food food) {
		FoodDetailResponse foodDetailResponse = new FoodDetailResponse();
		this.companyId = food.getCompany().getId();
		this.id = food.getId();
		this.name = food.getName();
		this.image = food.getImage();
		this.price = food.getPrice();
		this.status = food.getStatus();
		this.foodDetailResponses = foodDetailResponse.foodDetailResponses(food.getFoodDetails());
	}

	public List<FoodResponse> foodResponses(List<Food> foods) {
		return foods.stream().map(FoodResponse::new).toList();
	}
}
