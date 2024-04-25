package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.FoodDetailRequest;
import com.quocbao.bookingreser.request.FoodRequest;
import com.quocbao.bookingreser.response.FoodDetailResponse;
import com.quocbao.bookingreser.response.FoodResponse;

public interface FoodService {

	public void createFood(FoodRequest foodRequest);

	public void updateFood(Long id, FoodRequest foodRequest);

	public void uStatus(Long id, String status);

	public List<FoodResponse> listFoodByColumn(Long companyId, String keySearch);

	public List<FoodResponse> listFoodByType(Long companyId, String type);

	public List<FoodResponse> listFoodByCompanyId(Long companyId);
	
	public void addFoodDetail(Long idFood, List<FoodDetailRequest> foodDetailRequests);
	
	public List<FoodDetailResponse> listFoodDetail(Long idFood);
	
	public void updateFoodDetail(Long idFood, List<FoodDetailRequest> foodDetailRequests);
	
	public void removeFoodDetail(Long id);
}
