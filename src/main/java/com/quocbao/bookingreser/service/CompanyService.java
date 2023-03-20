package com.quocbao.bookingreser.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.response.CompanyResponse;

public interface CompanyService {

	public ResponseEntity<CompanyResponse> createCompany(CompanyRequest companyRequest);

	public ResponseEntity<CompanyResponse> detailCompany(Long id);

	public ResponseEntity<List<CompanyResponse>> updateCompany(CompanyRequest companyRequest);

	public ResponseEntity<List<CompanyResponse>> listCompanyByColumn(String nameColumn, String keySearch);

}
