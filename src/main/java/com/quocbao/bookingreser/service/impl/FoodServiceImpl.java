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
		Food food = new Food(foodRequest, companyRepository.findById(foodRequest.getCompanyId()));
		food.setTypes(types(foodRequest.getTypes()));
		List<FoodDetail> foodDetails = foodRequest.getFoodDetailRequests().stream()
				.map(x -> new FoodDetail(x, materialRepository.findById(x.getMaterialId()), food)).toList();
		food.setFoodDetails(foodDetails);
		foodRepository.save(food);
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
		food.setTypes(types(foodRequest.getTypes()));

		// Retrieve food detail existing
		List<FoodDetail> existingfoodDetails = food.getFoodDetails();
		// Retrieve food detail update or new
		List<FoodDetail> newFoodDetails = foodRequest.getFoodDetailRequests().stream()
				.map(x -> new FoodDetail(x, materialRepository.findById(x.getMaterialId()), food)).toList();

		// List food detail don't change
		List<FoodDetail> noChange = new ArrayList<>();
		// List food detail don't use
		List<FoodDetail> removeList = new ArrayList<>();
		// List food detail need update
		List<FoodDetail> updateList = new ArrayList<>();

		// Iterate through the existing Food Detail objects
		for (FoodDetail foodDetail : existingfoodDetails) {
			// Check if existing food detail object exist in new food detail
			boolean exist = false;
			for (FoodDetail newFoodDetail : newFoodDetails) {
				if (foodDetail.getMaterial().getId().equals(newFoodDetail.getMaterial().getId())
						&& foodDetail.getQuantity() == newFoodDetail.getQuantity()) {
					exist = true;
					// Check if existing food detail object and new food detail
					// equals materail and quantity
					// Add that in no change list
					noChange.add(foodDetail);
				} else if (foodDetail.getMaterial().getId().equals(newFoodDetail.getMaterial().getId())
						&& foodDetail.getQuantity() != newFoodDetail.getQuantity()) {
					exist = true;
					// Check if equals material, we need update quantity
					// Add that in update list
					foodDetail.setQuantity(newFoodDetail.getQuantity());
					updateList.add(foodDetail);
					break;
				}
			}
			if (!exist) {
				// Add the existing food detail object to the list to be romove
				removeList.add(foodDetail);
			}
		}

		// Remove food detail don't use in list old food detail
		existingfoodDetails.removeAll(removeList);

		// Iterate through the new food details objects
		for (FoodDetail foodDetail : newFoodDetails) {
			// Find food detail existing object, if it exist
			FoodDetail existingFoodDetail = findExistingFoodDetail(existingfoodDetails,
					foodDetail.getMaterial().getId());
			if (existingFoodDetail == null) {
				// Add new food detail object to the existing list
				existingfoodDetails.add(foodDetail);
			}
		}

		// Update food
		foodRepository.update(food);

		// Remove food detail existing object no change
		existingfoodDetails.removeAll(noChange);
		// Remove food datail existing object need update
		existingfoodDetails.removeAll(updateList);

		// Iterate through food detail object need update
		updateList.stream().forEach(x -> foodDetailRepository.update(x));
		// Iterate through food detail object need create
		existingfoodDetails.stream().forEach(x -> foodDetailRepository.save(x));
		// Iterate through food detail object remove
		removeList.stream().forEach(x -> foodDetailRepository.delete(x));
	}

	@Override
	public List<FoodResponse> listFoodByColumn(Long companyId, String keySearch) {
		return new FoodResponse().foodResponses(foodRepository.getAll(Company.class, Food_.COMPANYID, "id", companyId)
				.stream().filter(x -> x.getName().contains(keySearch)).toList());
	}

	@Override
	public List<FoodResponse> listFoodByType(Long companyId, String type) {
		List<Food> foods = foodRepository.getAll(Company.class, Food_.COMPANYID, "id", companyId);
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
		return new FoodResponse().foodResponses(foodRepository.getAll(Company.class, Food_.COMPANYID, "id", companyId));
	}

	@Override
	public void uStatus(Long id, String status) {
		foodRepository.uColumn(id, Food_.STATUS, status);
	}

	public Set<Types> types(List<Long> ids) {
		Set<Types> types = new HashSet<>();
		ids.stream().forEach(x -> types.add(typeRepository.findById(x)));
		return types;
	}

	public FoodDetail findExistingFoodDetail(List<FoodDetail> existFoodDetails, Long materialId) {
		for (FoodDetail foodDetail : existFoodDetails) {
			if (foodDetail.getMaterial().getId().equals(materialId)) {
				return foodDetail;
			}
		}
		return null;
	}
}
