package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.repository.CompanyRepository;

@Repository
public class CompanyRepositoryImpl extends AbstractRepository<Company> implements CompanyRepository{

	@Override
	public Company createCompany(Company company) {
		this.create(company);
		return company;
	}
	
	@Override
	public void updateCompany(Company company) {
		this.update(company);
	}

	@Override
	public Company detailCompany(Long id) {
		return this.getSession().get(Company.class, id);
	}

	@Override
	public List<Company> listCompanyByColumn(String nameColumn, String keySearch) {
		return this.listEnityByColumn(nameColumn, keySearch);
	}
}
