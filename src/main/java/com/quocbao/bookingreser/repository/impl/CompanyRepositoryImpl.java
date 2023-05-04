package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.repository.CompanyRepository;

@Repository
public class CompanyRepositoryImpl extends RepositoryImpl<Company> implements CompanyRepository {

	public CompanyRepositoryImpl() {
		super(Company.class);
	}
}
