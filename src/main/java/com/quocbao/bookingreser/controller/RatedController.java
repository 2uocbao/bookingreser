package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.RateRequest;
import com.quocbao.bookingreser.service.RatedService;

@RestController
@RequestMapping("/rated")
public class RatedController {

	@Autowired
	RatedService ratedService;

	@PostMapping("/create")
	ResponseEntity<Object> createRated(@RequestBody RateRequest rateRequest) {
		ratedService.createRated(rateRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Object> detailRated(@PathVariable Long id) {
		return new ResponseEntity<>(ratedService.detailRated(id), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<Object> updateRated(@PathVariable Long id, @RequestBody RateRequest rateRequest) {
		ratedService.updateRated(id, rateRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}/remove")
	ResponseEntity<Object> removeRated(@PathVariable Long id) {
		ratedService.deleteRated(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{companyId}")
	ResponseEntity<Object> listByCompany(@PathVariable Long companyId) {
		return new ResponseEntity<>(ratedService.listRatedByCompanyId(companyId), HttpStatus.OK);
	}
}
