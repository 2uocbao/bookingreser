package com.quocbao.bookingreser.repository.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.entity.metamodel.Company_;
import com.quocbao.bookingreser.entity.metamodel.Employee_;
import com.quocbao.bookingreser.repository.EmployeeRepository;

import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class EmployeeRepositoryImpl extends RepositoryImpl<Employee> implements EmployeeRepository {

	protected EmployeeRepositoryImpl() {
		super(Employee.class);
	}
	
	@Override
	public List<Employee> listEmployeeFromCompany(Long companyId){
		CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		Join<Employee, Company> join = root.join(Employee_.COMPANY, JoinType.INNER);
		criteriaQuery.multiselect(root.get(Employee_.ID), root.get(Employee_.FIRSTNAME), root.get(Employee_.LASTNAME), root.get(Employee_.IMAGE), root.get(Employee_.KPA), root.get(Employee_.CREATEDAT));
		criteriaQuery.where(criteriaBuilder.equal(join.get(Company_.ID), companyId));
		List<Tuple> tuples = getSession().createQuery(criteriaQuery).getResultList();
		List<Employee> employees = new ArrayList<>();
		for(Tuple tuple : tuples) {
			employees.add(new Employee((Long) tuple.get(0), (String) tuple.get(1), (String) tuple.get(2), (String) tuple.get(3), (Integer) tuple.get(4), (Timestamp) tuple.get(5)));
		}
		return employees;
	}

}
