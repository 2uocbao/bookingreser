package com.quocbao.bookingreser.controller;

import java.time.LocalDate;

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

import com.quocbao.bookingreser.request.WarehouseRequest;
import com.quocbao.bookingreser.service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

	@Autowired
	WarehouseService warehouseService;

	@PostMapping("/create")
	ResponseEntity<Object> createWarehouse(@RequestBody WarehouseRequest warehouseRequest) {
		warehouseService.createWarehouse(warehouseRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Object> detailWarehouse(@PathVariable Long id) {
		return new ResponseEntity<>(warehouseService.detailWarehouse(id), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<Object> updateWarehouse(@PathVariable Long id, @RequestBody WarehouseRequest warehouseRequest) {
		warehouseService.updateWarehouse(id, warehouseRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	ResponseEntity<Object> updateStatus(@PathVariable Long id, @RequestParam("status") String status) {
		warehouseService.updateStatus(id, status);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}/list")
	ResponseEntity<Object> listWarehouse(@PathVariable Long id, @RequestParam("start") LocalDate start,
			@RequestParam("end") LocalDate end) {
		return new ResponseEntity<>(warehouseService.warehouses(id, start, end), HttpStatus.OK);
	}
}
