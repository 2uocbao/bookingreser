package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;

public interface EmployeeRepository {

	public Employee createEmployee(Employee employee);
	
	public Employee detailEmployee(Long id);
	
	public Employee updateEmployee(Employee employee);
	
	public List<Employee> listEmployeeByCompanyId(Company company, Long companyId);
}
