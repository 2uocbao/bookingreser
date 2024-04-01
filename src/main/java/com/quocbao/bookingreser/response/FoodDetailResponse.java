package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.FoodDetail;

import lombok.Setter;

@Setter
public class FoodDetailResponse {

	@JsonProperty("material")
	private MaterialResponse materialResponse;
	
	@JsonProperty("quantity")
	private float quantity;

	public FoodDetailResponse(FoodDetail foodDetail) {
		this.materialResponse = new MaterialResponse(foodDetail.getMaterial());
		this.quantity = foodDetail.getQuantity();
	}

	public List<FoodDetailResponse> foodDetailResponses(List<FoodDetail> foodDetails) {
		return foodDetails.stream().map(FoodDetailResponse::new).toList();
	}

	public FoodDetailResponse() {

	}
}
