package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.request.FoodDetailRequest;

import lombok.Setter;

@Setter
public class FoodDetailResponse extends FoodDetailRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("material")
	private String materail;
	
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
