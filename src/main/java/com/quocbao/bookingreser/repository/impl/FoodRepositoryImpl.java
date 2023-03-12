package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.repository.FoodRepository;

@Repository
public class FoodRepositoryImpl extends AbstractRepository<Food> implements FoodRepository {

	@Override
	public Food createFood(Food food) {
		return this.create(food);
	}

	@Override
	public Food detailFood(Long id) {
		return this.detail(id);
	}

	@Override
	public Food updateFood(Food food) {
		return this.update(food);
	}

	@Override
	public List<Food> listFoodByColumn(String nameColumn, String keySearch) {
		return this.listEnityByColumn(nameColumn, keySearch);
	}

	@Override
	public List<Food> listFoodByCompanyId(Long id) {
		return this.listFoodByCompanyId(id);
	}

}
