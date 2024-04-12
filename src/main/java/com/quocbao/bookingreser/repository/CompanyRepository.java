package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.common.RepositoryDao;
import com.quocbao.bookingreser.entity.Company;

public interface CompanyRepository extends RepositoryDao<Company> {

	public List<Company> companyNearUser(String nearUser);
}
