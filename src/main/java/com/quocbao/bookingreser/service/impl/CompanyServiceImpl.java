package com.quocbao.bookingreser.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.entity.metamodel.Company_;
import com.quocbao.bookingreser.exception.BookingreserException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.TypeRepository;
import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.response.CompanyResponse;
import com.quocbao.bookingreser.service.CompanyService;
import com.quocbao.bookingreser.util.Status;

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
			throw new BookingreserException(HttpStatus.NOT_FOUND, "The company info is not found");
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

	@Override
	public List<CompanyResponse> companyByType(String type) {
		List<Company> companies = companyRepository.search(Company_.STATUS, Status.ON.toString());
		if (type.equals("ALL")) {
			return new CompanyResponse().companyResponses(companies);
		}
		companies.stream().forEach(x -> x.getTypes().stream().forEach(y -> {
			if (!y.getName().equals(type)) {
				companies.remove(x);
			}
		}));
		return new CompanyResponse().companyResponses(companies);
	}

	public void checkInfor(String email, String phone) {
		if (companyRepository.findByColumn(Company_.PHONE, phone) != null) {
			throw new BookingreserException(HttpStatus.CONFLICT, "Phone number already exist");
		}
		if (companyRepository.findByColumn(Company_.EMAIL, email) != null) {
			throw new BookingreserException(HttpStatus.CONFLICT, "Email already exist");
		}
	}

	public Set<Types> types(List<String> typeIds) {
		Set<Types> types = new HashSet<>();
		typeIds.stream().forEach(x -> types.add(typeRepository.findById(Long.parseLong(x))));
		return types;
	}
}
