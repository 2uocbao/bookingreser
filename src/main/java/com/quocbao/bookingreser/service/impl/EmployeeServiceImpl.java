package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.entity.metamodel.Employee_;
import com.quocbao.bookingreser.exception.AlreadyExistException;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.EmployeeRepository;
import com.quocbao.bookingreser.request.EmpUserRequest;
import com.quocbao.bookingreser.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public void createEmployee(Long companyId, EmpUserRequest empUserRequest) {
		checkInfor(empUserRequest.getEmail(), empUserRequest.getPhone());
		Employee employee = new Employee(empUserRequest, companyRepository.findById(companyId));
		employeeRepository.save(employee);
	}

	@Override
	public Employee detailEmployee(Long id) {
		Employee employee = employeeRepository.findById(id);
		if (employee == null) {
			throw new NotFoundException("Employee not found with id: " + id);
		}
		return employee;
	}

	@Override
	public void updateEmployee(Long id, EmpUserRequest empUserRequest) {
		Employee employee = employeeRepository.findById(id);
		checkInfor(employee.getEmail().equals(empUserRequest.getEmail()) ? null : empUserRequest.getEmail(),
				employee.getPhone().equals(empUserRequest.getPhone()) ? null : empUserRequest.getPhone());
		employee.setEmployee(empUserRequest);
		employeeRepository.update(employee);
	}

	@Override
	public List<Employee> listEmployeeByCompanyId(Long companyId) {
		return employeeRepository.getAll(Company.class, Employee_.COMPANYID, "id", companyId);
	}

	@Override
	public void updateKPA(String phone) {
		Employee employee = employeeRepository.findByColumn(Employee_.PHONE, phone);
		employeeRepository.uColumn(employee.getId(), "KPA", employee.getKpa() + 1);
	}

	public void checkInfor(String email, String phone) {
		if (employeeRepository.findByColumn(Employee_.PHONE, phone) != null) {
			throw new AlreadyExistException("Phone number already exist");
		}
		if (employeeRepository.findByColumn(Employee_.EMAIL, email) != null) {
			throw new AlreadyExistException("Email already exist");
		}
	}
}
