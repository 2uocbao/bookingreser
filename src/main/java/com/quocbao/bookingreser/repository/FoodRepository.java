package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.Food;

public interface FoodRepository {

	public Food createFood(Food food);
	
	public Food detailFood(Long id);
	
	public Food updateFood(Food food);
	
	public List<Food> listFoodByColumn(String nameColumn, String keySearch);
	
	public List<Food> listFoodByCompanyId(Long id);
}
