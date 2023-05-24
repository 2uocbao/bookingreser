package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.FoodDetail;

import lombok.Setter;

@Setter
public class FoodDetailResponse {
	
	@JsonProperty("material")
	private String materail;
	
	@JsonProperty("quantity")
	private float quantity;
	
	public FoodDetailResponse(FoodDetail foodDetail) {
		this.materail = foodDetail.getMaterial().getName();
		this.quantity = foodDetail.getQuantity();
	}
	
	public List<FoodDetailResponse> foodDetailResponses(List<FoodDetail> foodDetails){
		return foodDetails.stream().map(FoodDetailResponse::new).toList();
	}

	public FoodDetailResponse() {
		
	}
}
