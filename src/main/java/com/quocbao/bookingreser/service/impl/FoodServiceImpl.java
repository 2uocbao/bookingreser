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
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.entity.metamodel.FoodDetail_;
import com.quocbao.bookingreser.entity.metamodel.Food_;
import com.quocbao.bookingreser.exception.ValidationException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.FoodDetailRepository;
import com.quocbao.bookingreser.repository.FoodRepository;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.repository.TypeRepository;
import com.quocbao.bookingreser.request.FoodDetailRequest;
import com.quocbao.bookingreser.request.FoodRequest;
import com.quocbao.bookingreser.response.FoodDetailResponse;
import com.quocbao.bookingreser.response.FoodResponse;
import com.quocbao.bookingreser.service.FoodService;
import com.quocbao.bookingreser.util.Status;

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
		Food food = new Food(foodRequest);
		Company company = new Company();
		company.setId(foodRequest.getCompanyId());
		food.setCompany(company);
		food.setTypes(types(foodRequest.getTypes()));
		foodRepository.save(food);
	}

	@Override
	public void updateFood(Long id, FoodRequest foodRequest) {
		
	}

	@Override
	public List<FoodResponse> listFoodByColumn(Long companyId, String keySearch) {
		return new FoodResponse().foodResponses(foodRepository.getAll(Company.class, Food_.COMPANYID, "id", companyId.toString())
				.stream().filter(x -> x.getName().contains(keySearch)).toList());
	}

	@Override
	public List<FoodResponse> listFoodByType(Long companyId, String type) {
		List<Food> foods = foodRepository.getAll(Company.class, Food_.COMPANYID, "id", companyId.toString());
		List<FoodResponse> foodResponses = new ArrayList<>();
		foods.stream().forEach(x -> x.getTypes().stream().forEach(y -> {
			if (y.getName().equals(type)) {
				foodResponses.add(new FoodResponse(x));
			}
		}));
		return foodResponses;
	}

	@Override
	public List<FoodResponse> listFoodByCompanyId(Long companyId) {
		return new FoodResponse().foodResponses(foodRepository.getAll(Company.class, Food_.COMPANYID, "id", companyId.toString()));
	}

	@Override
	public void uStatus(Long id, String status) {
		if(!status.equals(Status.OUT_OF_STOCK.toString()))
		{
			List<FoodDetail> foodDetails = foodDetailRepository.getAll(Food.class, FoodDetail_.FOODID, "id", id.toString());
			for(FoodDetail foodDetail : foodDetails) {
				Material material = materialRepository.findById(foodDetail.getMaterial().getId());
				if(!material.getStatus().equals(Status.OUT_OF_STOCK.toString())) {
					throw new ValidationException("Please, Import more raw materials " + material.getName());
				}
			}
		}
		foodRepository.uColumn(id, Food_.STATUS, status);
	}
	
	@Override
	public void addFoodDetail(Long idFood, List<FoodDetailRequest> foodDetailRequests) {
		foodDetailRequests.stream().forEach(x -> foodDetailRepository
				.save(new FoodDetail(idFood, x)));
	}

	@Override
	public List<FoodDetailResponse> listFoodDetail(Long idFood){
		return new FoodDetailResponse().foodDetailResponses(foodDetailRepository.getAll(Food.class, FoodDetail_.FOODID, "id", idFood.toString()));
	}
	
	@Override
	public void updateFoodDetail(Long idFood, List<FoodDetailRequest> foodDetailRequests) {
		List<FoodDetail> foodDetails = foodDetailRepository.getAll(Food.class, FoodDetail_.FOODID, "id", idFood.toString());
		// List food detail need update
		ArrayList<FoodDetail> updateFoodDetails = new ArrayList<>();
		for (FoodDetail foodDetail : foodDetails) {
			for (FoodDetailRequest newFoodDetail : foodDetailRequests) {
				if (foodDetail.getMaterial().getId().equals(newFoodDetail.getMaterialId())
						&& foodDetail.getQuantity() != newFoodDetail.getQuantity()) {
					// Check if equals material, we need update quantity
					// Add that in update list
					foodDetail.setQuantity(newFoodDetail.getQuantity());
					updateFoodDetails.add(foodDetail);
					break;
				}
			}
		}
		updateFoodDetails.stream().forEach(x -> foodDetailRepository.update(x));
	}

	@Override
	public void removeFoodDetail(Long id) {
		FoodDetail foodDetail = new FoodDetail();
		foodDetail.setId(id);
		foodDetailRepository.delete(foodDetail);
	}

	public Set<Types> types(List<String> ids) {
		Set<Types> types = new HashSet<>();
		ids.stream().forEach(x -> types.add(typeRepository.findById(Long.parseLong(x))));
		return types;
	}
}
