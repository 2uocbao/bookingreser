package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Address;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.metamodel.Company_;
import com.quocbao.bookingreser.exception.ResourceNotFoundException;
import com.quocbao.bookingreser.exception.ValidationException;
import com.quocbao.bookingreser.repository.AddressRepository;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.TypeRepository;
import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.response.CompanyResponse;
import com.quocbao.bookingreser.security.jwt.JwtTokenProvider;
import com.quocbao.bookingreser.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	

	@Override
	public void createCompany(CompanyRequest companyRequest, String token) {
		String phone = jwtTokenProvider.extractUsername(token);
		checkInfor((long) 0, companyRequest.getEmail()); 
		Company company = new Company(companyRequest);
		company.setPhone(phone);
		company.setAddress(new Address(companyRequest.getAddressRequest()));
		companyRepository.save(company);
	}

	@Override
	public CompanyResponse detailCompany(Long id) {
		Company company = companyRepository.findById(id);
		if (company == null) {
			throw new ResourceNotFoundException("The company infor is not found");
		}
		return new CompanyResponse(company);
	}

	@Override
	public void updateCompany(CompanyRequest companyRequest) {
		checkInfor(companyRequest.getId(), companyRequest.getEmail());
		Company company = new Company(companyRequest);
		companyRepository.update(company);
	}

	@Override
	public void uStatusCompany(Long id, String status) {
		companyRepository.uColumn(id, Company_.STATUS, status);
	}

	@Override
	public List<CompanyResponse> listCompanyByAddress(String location) {
		return new CompanyResponse().companyResponses(companyRepository.companyNearUser(location));
	}

	@Override
	public void deleleCompany(Long id) {
		Company company = new Company();
		company.setId(id);
		companyRepository.delete(company);
	}
	
	public void checkInfor(Long id, String email) {
		Long retrieveId = companyRepository.checkValueExist(Company_.ID, Company_.EMAIL, email);
		if(id == 0 && retrieveId > 0) {
			throw new ValidationException(email);
		}
		else if(id > 0 && retrieveId != id && retrieveId > 0) {
			throw new ValidationException(email);
		}
	}
}
