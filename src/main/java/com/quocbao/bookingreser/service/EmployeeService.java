package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.EmployeeRequest;
import com.quocbao.bookingreser.response.EmployeeResponse;

public interface EmployeeService {

	public void createEmployee(EmployeeRequest employeeRequest);

	public EmployeeResponse detailEmployee(Long id);

	public void updateEmployee(EmployeeRequest employeeRequest);

	public List<EmployeeResponse> listEmployeeByCompanyId(Long companyId);

	public void updateKPA(String phone);
	
	public void deleteEmployee(Long id);
}
