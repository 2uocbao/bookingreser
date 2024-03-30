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
import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@PostMapping("/create")
	public ResponseEntity<DataResponse> createCompany(@RequestBody CompanyRequest companyRequest) {
		companyService.createCompany(companyRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<DataResponse> detailCompany(@PathVariable Long id) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, companyService.detailCompany(id)), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	public ResponseEntity<DataResponse> updateCompany(@PathVariable Long id,
			@RequestBody CompanyRequest companyRequest) {
		companyService.updateCompany(id, companyRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DataResponse> uStatusCompany(@PathVariable Long id, @RequestParam("status") String status) {
		companyService.uStatusCompany(id, status);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}
}
