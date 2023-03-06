package com.quocbao.bookingreser.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.repository.CompanyRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CompanyRepositoryImbl extends AbstractRepository<Serializable, Company> implements CompanyRepository{

	@Autowired
	protected EntityManager em;
	
	@SuppressWarnings("deprecation")
	@Override
	public Company createCompany(Company company) {
		this.getSession().save(company);
		return company;
	}

	@Override
	public Company detailCompany(Long id) {
		return this.getSession().get(Company.class, id);
	}

	@Override
	public List<Company> listCompanyByAddress(String address) {
		CriteriaBuilder builder = this.getBuilder();
		CriteriaQuery<Company> criteria = builder.createQuery(Company.class);
		Root<Company> translation = criteria.from(Company.class);
		criteria.select(translation);
		criteria.where(builder.equal(translation.get("address"), address));
		TypedQuery<Company> query = em.createQuery(criteria);
        return query.getResultList();
	}

	@Override
	public List<Company> listCompanyByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> searchCompany(String keySearch) {
		// TODO Auto-generated method stub
		return null;
	}

}
