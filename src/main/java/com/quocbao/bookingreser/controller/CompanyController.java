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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.response.CompanyResponse;
import com.quocbao.bookingreser.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createCompany(@RequestBody CompanyRequest companyRequest, @RequestHeader("Authorization") String authorization) {
		String token = authorization.replace("Bearer ", "");
		companyService.createCompany(companyRequest, token);
	}

	@GetMapping("/{id}/detail")
	@ResponseStatus(code = HttpStatus.OK)
	public CompanyResponse detailCompany(@PathVariable Long id) {
		return companyService.detailCompany(id);
	}

	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateCompany(@RequestBody CompanyRequest companyRequest) {
		companyService.updateCompany(companyRequest);
	}

	@PutMapping("/status/{id}/update")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void uStatusCompany(@PathVariable Long id, @RequestParam("status") String status) {
		companyService.uStatusCompany(id, status);
	}
	
	@GetMapping("/")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CompanyResponse> listCompanyByAddress(@RequestParam("nearUser") String nearUser){
		return companyService.listCompanyByAddress(nearUser);
	}
	
	@DeleteMapping("/{id}/delete")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCompany(@PathVariable Long id) {
		companyService.deleleCompany(id);
	}
}
