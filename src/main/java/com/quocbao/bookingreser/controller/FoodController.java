package com.quocbao.bookingreser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.FoodDetailRequest;
import com.quocbao.bookingreser.request.FoodRequest;
import com.quocbao.bookingreser.response.FoodDetailResponse;
import com.quocbao.bookingreser.response.FoodResponse;
import com.quocbao.bookingreser.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodController {

	@Autowired
	FoodService foodService;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createFood(@RequestBody FoodRequest foodRequest) {
		foodService.createFood(foodRequest);
	}

	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateFood(@RequestBody FoodRequest foodRequest) {
		foodService.updateFood(foodRequest);
	}

	@GetMapping("/{companyId}/search")
	@ResponseStatus(code = HttpStatus.OK)
	public List<FoodResponse> searchFood(@PathVariable Long companyId,
			@RequestParam("keySearch") String keySearch) {
		return foodService.listFoodByColumn(companyId, keySearch);
	}

	@PutMapping("/status/{id}/update")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateStatusFood(@PathVariable Long id, @RequestParam("status") String status) {
		foodService.uStatus(id, status);
	}

	@GetMapping("/{companyId}/company")
	@ResponseStatus(code = HttpStatus.OK)
	public List<FoodResponse> listFoodbyType(@PathVariable Long companyId,
			@RequestParam("type") String type) {
		return foodService.listFoodByType(companyId, type);
	}
	
	@PostMapping("/detail/{idFood}/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addFoodDetail(@PathVariable Long idFood, @RequestBody List<FoodDetailRequest> foodDetailRequests) {
		foodService.addFoodDetail(idFood, foodDetailRequests);
	}
	
	@GetMapping("/detail/{idFood}/get")
	@ResponseStatus(code = HttpStatus.OK)
	public List<FoodDetailResponse> getFoodDetail(@PathVariable Long idFood){
		return foodService.listFoodDetail(idFood);
	}
	
	@PutMapping("/detail/{idFood}/update")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateFoodDetail(@PathVariable Long idFood, @RequestBody List<FoodDetailRequest> foodDetailRequest) {
		foodService.updateFoodDetail(idFood, foodDetailRequest);
	}
	
	@DeleteMapping("/detail/{id}/delete")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteFoodDetail(@PathVariable Long id) {
		foodService.removeFoodDetail(id);
	}
}
