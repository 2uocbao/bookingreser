package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Food;

public interface FoodService {

	public Food createFood(Food food);

	public Food detailFood(Long id);

	public Food updateFood(Food food);

	public List<Food> listFoodByColumn(String nameColumn, String keySearch);

	public List<Food> listFoodByCompanyId(Long id);
}
