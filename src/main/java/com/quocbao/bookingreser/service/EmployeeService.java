package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.EmployeeRequest;
import com.quocbao.bookingreser.response.EmployeeResponse;

public interface EmployeeService {

	public void createEmployee(EmployeeRequest employeeRequest, String token);

	public EmployeeResponse detailEmployee(String token);

	public void updateEmployee(Long id, EmployeeRequest employeeRequest);

	public List<EmployeeResponse> listEmployeeByCompanyId(Long companyId);

	public void updateKPA(String phone);
}
