package com.quocbao.bookingreser.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.entity.metamodel.Company_;
import com.quocbao.bookingreser.exception.AlreadyExistException;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.TypeRepository;
import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.response.CompanyResponse;
import com.quocbao.bookingreser.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	TypeRepository typeRepository;

	@Override
	public void createCompany(CompanyRequest companyRequest) {
		checkInfor(companyRequest.getEmail(), companyRequest.getPhone());
		Company company = new Company(companyRequest);
		company.setTypes(types(companyRequest.getTypes()));
		companyRepository.save(company);
	}

	@Override
	public CompanyResponse detailCompany(Long id) {
		Company company = companyRepository.findById(id);
		if (company == null) {
			throw new NotFoundException("The company info is not available: " + id);
		}
		return new CompanyResponse(company);
	}

	@Override
	public void updateCompany(Long id, CompanyRequest companyRequest) {
		Company company = companyRepository.findById(id);
		checkInfor(company.getEmail().equals(companyRequest.getEmail()) ? null : companyRequest.getEmail(),
				company.getPhone().equals(companyRequest.getPhone()) ? null : companyRequest.getPhone());
		company.sompany(companyRequest);
		company.setTypes(types(companyRequest.getTypes()));
		companyRepository.update(company);
	}

	@Override
	public void uStatusCompany(Long id, String status) {
		companyRepository.uColumn(id, Company_.STATUS, status);
	}

	public void checkInfor(String email, String phone) {
		if (companyRepository.findByColumn(Company_.PHONE, phone) != null) {
			throw new AlreadyExistException("Phone number already exist");
		}
		if (companyRepository.findByColumn(Company_.EMAIL, email) != null) {
			throw new AlreadyExistException("Email already exist");
		}
	}

	public Set<Types> types(List<Long> typeIds) {
		Set<Types> types = new HashSet<>();
		typeIds.stream().forEach(x -> types.add(typeRepository.findById(x)));
		return types;
	}
}
