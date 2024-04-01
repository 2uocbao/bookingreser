package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Address;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.metamodel.Company_;
import com.quocbao.bookingreser.exception.BookingreserException;
import com.quocbao.bookingreser.repository.AddressRepository;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.TypeRepository;
import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.response.CompanyResponse;
import com.quocbao.bookingreser.security.jwt.JwtTokenProvider;
import com.quocbao.bookingreser.service.CompanyService;
import com.quocbao.bookingreser.util.Status;

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
		checkInfor(companyRequest.getEmail());
		Company company = new Company(companyRequest);
		company.setPhone(phone);
		Address address = new Address(companyRequest.getAddressRequest());
		addressRepository.save(address);
		company.setAddress(address);
		companyRepository.save(company);
	}

	@Override
	public CompanyResponse detailCompany(Long id) {
		Company company = companyRepository.findById(id);
		if (company == null) {
			throw new BookingreserException(HttpStatus.NOT_FOUND, "The company info is not found");
		}
		return new CompanyResponse(company);
	}

	@Override
	public void updateCompany(Long id, CompanyRequest companyRequest) {
		Company company = companyRepository.findById(id);
		checkInfor(company.getEmail().equals(companyRequest.getEmail()) ? null : companyRequest.getEmail());
		company.company(companyRequest);
		Address address = addressRepository.findById(company.getAddress().getId());
		address.address(companyRequest.getAddressRequest());
		companyRepository.update(company);
		addressRepository.update(address);
	}

	@Override
	public void uStatusCompany(Long id, String status) {
		companyRepository.uColumn(id, Company_.STATUS, status);
	}
	
	public List<Company> listCompany(){
		return companyRepository.search(Company_.STATUS, Status.ON.toString());
	}

	public void checkInfor(String email) {
		if (companyRepository.findByColumn(Company_.EMAIL, email) != null) {
			throw new BookingreserException(HttpStatus.CONFLICT, "Email already exist");
		}
	}

	@Override
	public List<CompanyResponse> listCompanyByAddress(String location) {
		return new CompanyResponse().companyResponses(  companyRepository.getAll(Company.class, Company_.ADDRESS, "province", location.toString()));
	}
}
