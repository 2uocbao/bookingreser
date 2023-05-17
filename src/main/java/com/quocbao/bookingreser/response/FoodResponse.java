package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.request.FoodRequest;

import lombok.Setter;

@Setter
public class FoodResponse extends FoodRequest {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("status")
	private String status;

	@JsonProperty("FoodDetail")
	private List<FoodDetailResponse> foodDetailResponses;

	public FoodResponse() {

	}

	public FoodResponse(Food food) {
		FoodDetailResponse foodDetailResponse = new FoodDetailResponse();
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
