package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Company;

public interface CompanyService {

	public Company createCompany(Company company);

	public Company detailCompany(Long id);

	public void updateCompany(Company company);

	public List<Company> listCompanyByColumn(String nameColumn, String keySearch);

}
