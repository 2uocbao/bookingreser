package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.request.FoodDetailRequest;
import com.quocbao.bookingreser.request.FoodRequest;

public interface FoodService {

	// Food
	public void createFood(FoodRequest foodRequest);

	public Food detailFood(Long id);

	public void updateFood(Long id, FoodRequest foodRequest);
	
	public void uStatus(Long id, int value);

	public List<Food> listFoodByColumn(Long companyId, String nameColumn, String keySearch);

	public List<Food> listFoodByCompanyId(Long companyId);

	// FoodDetail
	public void createFoodDetail(FoodDetailRequest detailRequest);

	public List<FoodDetail> foodDetail(Long foodId);

	public void updateFoodDetail(Long id, FoodDetailRequest detailRequest);

	public void rMaterialFD(Long id);
}
