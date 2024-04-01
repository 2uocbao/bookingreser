package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.common.DataResponse;
import com.quocbao.bookingreser.request.EmployeeRequest;
import com.quocbao.bookingreser.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/create")
	ResponseEntity<DataResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest, @RequestHeader("Authorization") String authorization) {
		String token = authorization.replace("Bearer ", "");
		employeeService.createEmployee(employeeRequest, token);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/detail")
	ResponseEntity<DataResponse> detailEmployee(@RequestHeader("Authorization") String authorization) {
		String token = authorization.replace("Bearer ", "");
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, employeeService.detailEmployee(token)), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<DataResponse> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
		employeeService.updateEmployee(id, employeeRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/{companyId}/byCompany")
	ResponseEntity<DataResponse> allEmployeeByCompany(@PathVariable Long companyId) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, employeeService.listEmployeeByCompanyId(companyId)),
				HttpStatus.OK);
	}

	@PutMapping("/")
	ResponseEntity<DataResponse> kpa(@RequestParam("phone") String phone) {
		employeeService.updateKPA(phone);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}
}
