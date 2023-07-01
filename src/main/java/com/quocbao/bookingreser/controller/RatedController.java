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

import com.quocbao.bookingreser.common.DataResponse;
import com.quocbao.bookingreser.request.RateRequest;
import com.quocbao.bookingreser.service.RatedService;

@RestController
@RequestMapping("/rated")
public class RatedController {

	@Autowired
	RatedService ratedService;

	@PostMapping("/create")
	ResponseEntity<DataResponse> createRated(@RequestBody RateRequest rateRequest) {
		ratedService.createRated(rateRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<DataResponse> detailRated(@PathVariable Long id) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, ratedService.detailRated(id)), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<DataResponse> updateRated(@PathVariable Long id, @RequestBody RateRequest rateRequest) {
		ratedService.updateRated(id, rateRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@DeleteMapping("/{id}/remove")
	ResponseEntity<DataResponse> removeRated(@PathVariable Long id) {
		ratedService.deleteRated(id);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/{companyId}")
	ResponseEntity<DataResponse> listByCompany(@PathVariable Long companyId) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, ratedService.listRatedByCompanyId(companyId)),
				HttpStatus.OK);
	}
}
