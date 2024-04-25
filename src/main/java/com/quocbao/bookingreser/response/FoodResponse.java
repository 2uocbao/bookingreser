package com.quocbao.bookingreser.response;

import java.util.List;

import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.request.FoodRequest;

import lombok.Setter;

@Setter
public class FoodResponse extends FoodRequest{

	public FoodResponse() {

	}

	public FoodResponse(Food food) {
		this.id = food.getId();
		this.name = food.getName();
		this.image = food.getImage();
		this.price = food.getPrice();
		this.status = food.getStatus();
		this.types = food.getTypes().stream().map(Types::getName).toList();
	}

	public List<FoodResponse> foodResponses(List<Food> foods) {
		return foods.stream().map(FoodResponse::new).toList();
	}

}
