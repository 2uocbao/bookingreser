package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.Company;

public interface CompanyRepository {
	
	public Company createCompany(Company company);
	
	public Company detailCompany(Long id);
	
	public void updateCompany(Long id, Company company);
	
	public List<Company> listCompanyByAddress(String address);
	
	public List<Company> listCompanyByType(String type);
	
	public List<Company> searchCompany(String keySearch);
}
