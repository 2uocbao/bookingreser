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

import com.quocbao.bookingreser.request.EmployeeRequest;
import com.quocbao.bookingreser.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/create")
	ResponseEntity<Object> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		employeeService.createEmployee(employeeRequest.getCompanyId(), employeeRequest);
		return new ResponseEntity<>("Create employee success", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Object> detailEmployee(@PathVariable Long id) {
		return new ResponseEntity<>(employeeService.detailEmployee(id), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<Object> updateEmployee(@PathVariable Long id,@RequestBody EmployeeRequest employeeRequest) {
		employeeService.updateEmployee(id, employeeRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{companyId}/byCompany")
	ResponseEntity<Object> allEmployeeByCompany(@PathVariable Long companyId) {
		return new ResponseEntity<>(employeeService.listEmployeeByCompanyId(companyId), HttpStatus.OK);
	}

	@PutMapping("/")
	ResponseEntity<Object> kpa(@RequestParam("phone") String phone) {
		employeeService.updateKPA(phone);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
