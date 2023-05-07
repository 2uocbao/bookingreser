package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.request.FoodRequest;

import lombok.Setter;

@Setter
public class FoodResponse extends FoodRequest{

	@JsonProperty("id")
	private Long id;
	
	public FoodResponse() {
		
	}
	
	public FoodResponse(Food food) {
		this.id = food.getId();
		this.name = food.getName();
		this.image = food.getImage();
		this.price = food.getPrice();
	}
	
	public List<FoodResponse> foodResponses(List<Food> foods){
		return foods.stream().map(FoodResponse::new).toList();
	}
}
