package com.quocbao.bookingreser.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.request.FoodDetailRequest;

import lombok.Setter;

@Setter
public class FoodDetailResponse extends FoodDetailRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("food_id")
	private Long foodId;
	
	public FoodDetailResponse(FoodDetail foodDetail) {
		this.id = foodDetail.getId();
		this.foodId = foodDetail.getFood().getId();
		this.quantity = foodDetail.getQuantity();
	}
}
