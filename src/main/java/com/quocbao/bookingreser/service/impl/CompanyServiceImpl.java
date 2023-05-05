package com.quocbao.bookingreser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.metamodel.Company_;
import com.quocbao.bookingreser.exception.AlreadyExistException;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public void createCompany(CompanyRequest companyRequest) {
		checkInfor(companyRequest.getEmail(), companyRequest.getPhone());
		Company company = new Company(companyRequest);
		companyRepository.save(company);
	}

	@Override
	public Company detailCompany(Long id) {
		if (companyRepository.findById(id) == null) {
			throw new NotFoundException("The company info is not available: " + id);
		}
		return companyRepository.findById(id);
	}

	@Override
	public void updateCompany(Long id, CompanyRequest companyRequest) {
		Company company = companyRepository.findById(id);
		checkInfor(companyRequest.getEmail().equals(company.getEmail()) ? null : companyRequest.getEmail(),
				companyRequest.getPhone().equals(company.getPhone()) ? null : companyRequest.getPhone());
		company.sompany(companyRequest);
		companyRepository.update(company);
	}

	public void checkInfor(String email, String phone) {
		if (companyRepository.findByColumn(Company_.PHONE, phone) != null) {
			throw new AlreadyExistException("Phone number already exist");
		}
		if (companyRepository.findByColumn(Company_.EMAIL, email) != null) {
			throw new AlreadyExistException("Email already exist");
		}
	}

	@Override
	public void uStatusCompany(Long id,  int status) {
		companyRepository.uColumn(id, Company_.STATUS ,status);
	}
}
