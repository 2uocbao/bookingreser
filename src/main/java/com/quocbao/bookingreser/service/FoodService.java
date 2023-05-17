package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.FoodRequest;
import com.quocbao.bookingreser.response.FoodResponse;

public interface FoodService {
	
	public void createFood(FoodRequest foodRequest);

	public FoodResponse detailFood(Long id);

	public void updateFood(Long id, FoodRequest foodRequest);

	public void uStatus(Long id, String status);

	public List<FoodResponse> listFoodByColumn(Long companyId, String nameColumn, String keySearch);

	public List<FoodResponse> listFoodByCompanyId(Long companyId);
}
