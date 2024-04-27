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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.EmployeeRequest;
import com.quocbao.bookingreser.response.EmployeeResponse;
import com.quocbao.bookingreser.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		employeeService.createEmployee(employeeRequest);
	}

	@GetMapping("/{id}/detail")
	@ResponseStatus(code = HttpStatus.OK)
	public EmployeeResponse detailEmployee(@PathVariable Long id) {
		return employeeService.detailEmployee(id);
	}

	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateEmployee(@RequestBody EmployeeRequest employeeRequest) {
		employeeService.updateEmployee(employeeRequest);
	}

	@GetMapping("/{companyId}/company")
	@ResponseStatus(code = HttpStatus.OK)
	public List<EmployeeResponse> allEmployeeByCompany(@PathVariable Long companyId) {
		return employeeService.listEmployeeByCompanyId(companyId);
	}
	
	@DeleteMapping("/{id}/delete")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable Long id) { 
		employeeService.deleteEmployee(id);
	}
}
