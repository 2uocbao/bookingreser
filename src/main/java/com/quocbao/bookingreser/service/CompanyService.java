package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.response.CompanyResponse;

public interface CompanyService {

	public void createCompany(CompanyRequest companyRequest, String token);

	public CompanyResponse detailCompany(Long id);

	public void updateCompany(CompanyRequest companyRequest);

	public void uStatusCompany(Long id, String status);
	
	public void deleleCompany(Long id);
	
	public List<CompanyResponse> listCompanyByAddress(String location);
}
