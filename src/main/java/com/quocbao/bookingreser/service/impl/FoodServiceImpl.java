package com.quocbao.bookingreser.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.entity.metamodel.Food_;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.FoodDetailRepository;
import com.quocbao.bookingreser.repository.FoodRepository;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.repository.TypeRepository;
import com.quocbao.bookingreser.request.FoodDetailRequest;
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
	@Autowired
	TypeRepository typeRepository;

	@Override
	public void createFood(FoodRequest foodRequest) {
		Food food = new Food();
		food.setFoodDetails(foodDetails(foodRequest.getFoodDetailRequests()));
		food.setTypes(types(foodRequest.getTypes()));
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
		food.setFoodDetails(foodDetails(foodRequest.getFoodDetailRequests()));
		food.setTypes(types(foodRequest.getTypes()));
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

	public List<FoodDetail> foodDetails(List<FoodDetailRequest> foodDetailRequests) {
		List<FoodDetail> foodDetails = new ArrayList<>();
		foodDetailRequests.stream()
				.map(x -> foodDetails.add(new FoodDetail(x, materialRepository.findById(x.getMaterialId()))));
		return foodDetails;
	}

	public Set<Types> types(List<Long> ids) {
		Set<Types> types = new HashSet<>();
		ids.stream().map(x -> types.add(typeRepository.findById(x)));
		return types;
	}
}
