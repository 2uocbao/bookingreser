package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Employee;

public interface EmployeeService {

public Employee createEmployee(Employee employee);
	
	public Employee detailEmployee(Long id);
	
	public Employee updateEmployee(Employee employee);
	
	public List<Employee> listEmployeeByCompanyId(Long companyId);

}
