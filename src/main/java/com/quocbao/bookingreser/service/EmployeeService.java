package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.EmployeeRequest;
import com.quocbao.bookingreser.response.EmployeeResponse;

public interface EmployeeService {

	public void createEmployee(Long companyId, EmployeeRequest employeeRequest);

	public EmployeeResponse detailEmployee(Long id);

	public void updateEmployee(Long id, EmployeeRequest employeeRequest);

	public List<EmployeeResponse> listEmployeeByCompanyId(Long companyId);

	public void updateKPA(String phone);
}
