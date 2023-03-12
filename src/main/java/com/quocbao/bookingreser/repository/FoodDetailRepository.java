package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.FoodDetail;

public interface FoodDetailRepository {

	public FoodDetail createFoodDetail(FoodDetail foodDetail);
	
	public List<FoodDetail> listFoodDetailByFoodId(Long foodId);
	
	public FoodDetail updateFoodDetail(FoodDetail foodDetail);
}
