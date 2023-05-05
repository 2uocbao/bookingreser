package com.quocbao.bookingreser.service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.request.CompanyRequest;

public interface CompanyService {

	public void createCompany(CompanyRequest companyRequest);

	public Company detailCompany(Long id);

	public void updateCompany(Long id, CompanyRequest companyRequest);

	public void uStatusCompany(Long id, int status);
}
