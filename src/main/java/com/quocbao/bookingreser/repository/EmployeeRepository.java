package com.quocbao.bookingreser.repository;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryDao;
import com.quocbao.bookingreser.entity.Employee;

@Repository
public interface EmployeeRepository extends RepositoryDao<Employee> {

}
