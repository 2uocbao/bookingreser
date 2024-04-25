package com.quocbao.bookingreser.response;

import java.util.List;

import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.request.FoodDetailRequest;

import lombok.Setter;

@Setter
public class FoodDetailResponse extends FoodDetailRequest{

	public FoodDetailResponse(FoodDetail foodDetail) {
		this.id = foodDetail.getId();
		this.materialId = foodDetail.getMaterial().getId();
		this.quantity = foodDetail.getQuantity();
	}

	public List<FoodDetailResponse> foodDetailResponses(List<FoodDetail> foodDetails) {
		return foodDetails.stream().map(FoodDetailResponse::new).toList();
	}

	public FoodDetailResponse() {

	}
}
