package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.common.RepositoryDao;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Types;

public interface CompanyRepository extends RepositoryDao<Company> {

	public List<Types> types(Long id);

}
