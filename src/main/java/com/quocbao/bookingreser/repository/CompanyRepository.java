package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.Company;

public interface CompanyRepository {
	
	public Company createCompany(Company company);
	
	public Company detailCompany(Long id);
	
	public void updateCompany(Company company);
	
	public List<Company> listCompanyByColumn(String nameColumn, String keySearch);
}
