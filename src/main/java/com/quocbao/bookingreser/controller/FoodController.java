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
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.FoodRequest;
import com.quocbao.bookingreser.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	FoodService foodService;

	@PostMapping("/create")
	public ResponseEntity<Object> createFood(@RequestBody FoodRequest foodRequest) {
		foodService.createFood(foodRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> detailFood(@PathVariable Long id) {
		foodService.detailFood(id);
		return new ResponseEntity<>(foodService.detailFood(id), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	public ResponseEntity<Object> updateFood(@PathVariable Long id, @RequestBody FoodRequest foodRequest) {
		foodService.updateFood(id, foodRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
