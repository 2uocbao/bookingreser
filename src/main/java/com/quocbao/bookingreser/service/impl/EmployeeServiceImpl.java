package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.entity.metamodel.Employee_;
import com.quocbao.bookingreser.exception.ResourceNotFoundException;
import com.quocbao.bookingreser.exception.ValidationException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.EmployeeRepository;
import com.quocbao.bookingreser.request.EmployeeRequest;
import com.quocbao.bookingreser.response.EmployeeResponse;
import com.quocbao.bookingreser.security.jwt.JwtTokenProvider;
import com.quocbao.bookingreser.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Override
	public void createEmployee(EmployeeRequest employeeRequest) {
		checkInfor((long) 0, employeeRequest.getEmail());
		Employee employee = new Employee(employeeRequest);
		Company company = new Company();
		company.setId(employeeRequest.getCompanyId());
		employee.setCompany(company);
		employeeRepository.save(employee);
	}

	@Override
	public EmployeeResponse detailEmployee(Long id) {
		Employee employee = employeeRepository.findById(id);
		if (employee == null) {
			throw new ResourceNotFoundException("Employee not found");
		}
		return new EmployeeResponse(employee);
	}

	@Override
	public void updateEmployee(EmployeeRequest employeeRequest) {
		checkInfor(employeeRequest.getId(), employeeRequest.getEmail());
		Employee employee = new Employee(employeeRequest);
		Company company = new Company();
		company.setId(employeeRequest.getCompanyId());
		employee.setCompany(company);
		employeeRepository.update(employee);
	}

	@Override
	public List<EmployeeResponse> listEmployeeByCompanyId(Long companyId) {
		return new EmployeeResponse().employeeResponses(employeeRepository.listEmployeeFromCompany(companyId));
	}

	@Override
	public void updateKPA(String phone) {
		Employee employee = employeeRepository.findByColumn(Employee_.PHONE, phone);
		employee.setKpa(employee.getKpa() + 1);
		employeeRepository.update(employee);
	}
	
	@Override
	public void deleteEmployee(Long id) {
		Employee employee = new Employee();
		employee.setId(id);
		employeeRepository.delete(employee);
	}

	public void checkInfor(Long id, String email) {
		Long retrieveId = employeeRepository.checkValueExist(Employee_.ID, Employee_.EMAIL, email);
		if(id == 0 && retrieveId > 0) {
			throw new ValidationException(email);
		}
		else if(id > 0 && retrieveId != id && retrieveId > 0) {
			throw new ValidationException(email);
		}
	}
}
