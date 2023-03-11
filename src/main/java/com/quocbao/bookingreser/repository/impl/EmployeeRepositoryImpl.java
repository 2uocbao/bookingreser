package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.repository.EmployeeRepository;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

@Repository
public class EmployeeRepositoryImpl extends AbstractRepository<Employee> implements EmployeeRepository{

	@Override
	public Employee createEmployee(Employee employee) {
		return this.create(employee);
	}

	@Override
	public Employee detailEmployee(Long id) {
		return this.detail(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return this.update(employee);
	}

	@Override
	public List<Employee> listEmployeeByCompanyId(Long companyId) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Company> translation = criteria.from(Company.class);
		Path<Employee> path = translation.get("company");
		criteria.select(path);
		criteria.where(builder.equal(translation.get("id"), companyId));
		TypedQuery<Employee> query = this.entityManager.createQuery(criteria);
		return query.getResultList();
	}
}
