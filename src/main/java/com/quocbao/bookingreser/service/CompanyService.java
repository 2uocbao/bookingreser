package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.response.CompanyResponse;

public interface CompanyService {

	public void createCompany(CompanyRequest companyRequest);

	public CompanyResponse detailCompany(Long id);

	public void updateCompany(Long id, CompanyRequest companyRequest);

	public void uStatusCompany(Long id, String status);

	public List<CompanyResponse> companyByType(String type);
}
