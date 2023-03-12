package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.repository.FoodDetailRepository;

@Repository
public class FoodDetailRepositoryImpl extends AbstractRepository<FoodDetail> implements FoodDetailRepository {

	@Override
	public FoodDetail createFoodDetail(FoodDetail foodDetail) {
		return this.create(foodDetail);
	}

	@Override
	public List<FoodDetail> listFoodDetailByFoodId(Long foodId) {
		return this.listFoodDetailByFoodId(foodId);
	}

	@Override
	public FoodDetail updateFoodDetail(FoodDetail foodDetail) {
		return this.update(foodDetail);
	}

}
