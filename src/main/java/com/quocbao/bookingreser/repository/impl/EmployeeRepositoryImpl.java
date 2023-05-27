package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepositoryImpl extends RepositoryImpl<Employee> implements EmployeeRepository {

	protected EmployeeRepositoryImpl() {
		super(Employee.class);
	}

}
