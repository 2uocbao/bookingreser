package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.request.EmpUserRequest;

public interface EmployeeService {

	public void createEmployee(Long companyId, EmpUserRequest empUserRequest);
	
	public Employee detailEmployee(Long id);
	
	public void updateEmployee(Long id, EmpUserRequest empUserRequest);
	
	public List<Employee> listEmployeeByCompanyId(Long companyId);
	
	public void updateKPA(String phone);
}
