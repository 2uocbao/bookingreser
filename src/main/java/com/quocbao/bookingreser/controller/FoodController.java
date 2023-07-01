package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.common.DataResponse;
import com.quocbao.bookingreser.request.FoodRequest;
import com.quocbao.bookingreser.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	FoodService foodService;

	@PostMapping("/create")
	public ResponseEntity<DataResponse> createFood(@RequestBody FoodRequest foodRequest) {
		foodService.createFood(foodRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DataResponse> detailFood(@PathVariable Long id) {
		foodService.detailFood(id);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, foodService.detailFood(id)), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	public ResponseEntity<DataResponse> updateFood(@PathVariable Long id, @RequestBody FoodRequest foodRequest) {
		foodService.updateFood(id, foodRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/{companyId}/search")
	public ResponseEntity<DataResponse> searchFood(@PathVariable Long companyId,
			@RequestParam("keySearch") String keySearch) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, foodService.listFoodByColumn(companyId, keySearch)),
				HttpStatus.OK);
	}

	@GetMapping("/{companyId}/byCompany")
	public ResponseEntity<DataResponse> listByCompany(@PathVariable Long companyId) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, foodService.listFoodByCompanyId(companyId)),
				HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DataResponse> updateStatusFood(@PathVariable Long id, @RequestParam("status") String status) {
		foodService.uStatus(id, status);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/{companyId}/by")
	public ResponseEntity<DataResponse> listFoodbyType(@PathVariable Long companyId,
			@RequestParam("type") String type) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, foodService.listFoodByType(companyId, type)),
				HttpStatus.OK);
	}
}
