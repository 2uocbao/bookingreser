package com.quocbao.bookingreser.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.entity.metamodel.Food_;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.FoodDetailRepository;
import com.quocbao.bookingreser.repository.FoodRepository;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.request.FoodRequest;
import com.quocbao.bookingreser.response.FoodResponse;
import com.quocbao.bookingreser.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodRepository foodRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	FoodDetailRepository foodDetailRepository;
	@Autowired
	MaterialRepository materialRepository;

	@Override
	public void createFood(FoodRequest foodRequest) {
		Food food = new Food();
		List<FoodDetail> foodDetails = new ArrayList<>();
		foodRequest.getFoodDetailRequests().stream()
				.map(x -> foodDetails.add(new FoodDetail(x, materialRepository.findById(x.getMaterialId()))));
		food.setFoodDetails(foodDetails);
		foodRepository.save(new Food(foodRequest, companyRepository.findById(foodRequest.getCompanyId())));
	}

	@Override
	public FoodResponse detailFood(Long id) {
		Food food = foodRepository.findById(id);
		if (food == null) {
			throw new NotFoundException("Food not found with: " + id.toString());
		}
		return new FoodResponse(food);
	}

	@Override
	public void updateFood(Long id, FoodRequest foodRequest) {
		Food food = foodRepository.findById(id);
		food.setFood(foodRequest);
		foodRepository.update(food);
	}

	@Override
	public List<FoodResponse> listFoodByColumn(Long companyId, String nameColumn, String keySearch) {
		return new FoodResponse().foodResponses(foodRepository.getAll(Company.class, Food_.COMPANYID, "id", companyId)
				.stream().filter(x -> x.getName().contains(keySearch)).toList());
	}

	@Override
	public List<FoodResponse> listFoodByCompanyId(Long companyId) {
		return new FoodResponse().foodResponses(foodRepository.getAll(Company.class, Food_.COMPANYID, "id", companyId));
	}

	@Override
	public void uStatus(Long id, String status) {
		foodRepository.uColumn(id, Food_.STATUS, status);
	}
}
