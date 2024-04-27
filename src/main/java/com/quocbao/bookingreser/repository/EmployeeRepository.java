package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.common.RepositoryDao;
import com.quocbao.bookingreser.entity.Employee;

public interface EmployeeRepository extends RepositoryDao<Employee> {
	
	public List<Employee> listEmployeeFromCompany(Long companyId);
	
}
