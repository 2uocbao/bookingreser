package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.EmpUserRequest;
import com.quocbao.bookingreser.response.EmployeeResponse;

public interface EmployeeService {

	public void createEmployee(Long companyId, EmpUserRequest empUserRequest);
	
	public EmployeeResponse detailEmployee(Long id);
	
	public void updateEmployee(Long id, EmpUserRequest empUserRequest);
	
	public List<EmployeeResponse> listEmployeeByCompanyId(Long companyId);
	
	public void updateKPA(String phone);
	
	public void updateStatus(Long id, String status);
}
