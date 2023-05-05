package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.entity.metamodel.FoodDetail_;
import com.quocbao.bookingreser.entity.metamodel.Food_;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.FoodDetailRepository;
import com.quocbao.bookingreser.repository.FoodRepository;
import com.quocbao.bookingreser.request.FoodDetailRequest;
import com.quocbao.bookingreser.request.FoodRequest;
import com.quocbao.bookingreser.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodRepository foodRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	FoodDetailRepository foodDetailRepository;

	// Food
	@Override
	public void createFood(FoodRequest foodRequest) {
		foodRepository.save(new Food(foodRequest, companyRepository.findById(foodRequest.getCompanyId())));
	}

	@Override
	public Food detailFood(Long id) {
		if (foodRepository.findById(id) == null) {
			throw new NotFoundException("Food not found with: " + id.toString());
		}
		return foodRepository.findById(id);
	}

	@Override
	public void updateFood(Long id, FoodRequest foodRequest) {
		Food food = foodRepository.findById(id);
		food.setFood(foodRequest);
		foodRepository.update(food);
	}

	@Override
	public List<Food> listFoodByColumn(String nameColumn, String keySearch) {
		return foodRepository.getByColumn(nameColumn, keySearch);
	}

	@Override
	public List<Food> listFoodByCompanyId(Long companyId) {
		return foodRepository.getAll(Company.class, Food_.COMPANYID, companyId);
	}

	@Override
	public void uStatus(Long id, int value) {
		foodRepository.uColumn(id, Food_.STATUS, value);
	}

	// FoodDetail
	@Override // add material
	public void createFoodDetail(FoodDetailRequest detailRequest) {
		foodDetailRepository
				.save(new FoodDetail(detailRequest, foodRepository.findById(detailRequest.getFoodId()), null));
	}

	@Override
	public List<FoodDetail> foodDetail(Long foodId) {
		return foodDetailRepository.getByColumn(FoodDetail_.FOODID, foodId.toString());
	}

	@Override
	public void updateFoodDetail(Long id, FoodDetailRequest detailRequest) {
		foodDetailRepository.uColumn(id, "quantity", detailRequest.getQuantity());
	}

	@Override
	public void rMaterialFD(Long id) {
		foodDetailRepository.delete(foodDetailRepository.findById(id));
	}
}
