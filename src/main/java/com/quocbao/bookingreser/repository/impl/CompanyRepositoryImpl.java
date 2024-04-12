package com.quocbao.bookingreser.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Address;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.metamodel.Address_;
import com.quocbao.bookingreser.entity.metamodel.Company_;
import com.quocbao.bookingreser.repository.CompanyRepository;

import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class CompanyRepositoryImpl extends RepositoryImpl<Company> implements CompanyRepository  {

	public CompanyRepositoryImpl() {
		super(Company.class);
	}

	@Override
	public List<Company> companyNearUser(String nearUser) {
		CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
		Root<Company> root = criteriaQuery.from(Company.class);
		Join<Company, Address> join = root.join(Company_.ADDRESS, JoinType.INNER);
		criteriaQuery.multiselect(root.get(Company_.ID), root.get(Company_.NAME), root.get(Company_.IMAGE), join.get(Address_.DISTRICT), join.get(Address_.PROVINCE));
		criteriaQuery.where(criteriaBuilder.equal(join.get(Address_.PROVINCE), nearUser));
		List<Tuple> tuples = getSession().createQuery(criteriaQuery).getResultList();
		List<Company> companies = new ArrayList<>();
		for(Tuple tuple : tuples) {
			Company company = new Company();
			Address address = new Address();
			company.setId((Long) tuple.get(0));
			company.setName((String) tuple.get(1));
			company.setImage((String) tuple.get(2));
			address.setDistrict((String) tuple.get(3));
			address.setProvince((String) tuple.get(4));
			company.setAddress(address);
			companies.add(company);
		}
		return companies;
	}

}
