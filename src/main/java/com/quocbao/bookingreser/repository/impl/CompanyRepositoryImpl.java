package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.repository.CompanyRepository;

import jakarta.persistence.Query;

@Repository
public class CompanyRepositoryImpl extends RepositoryImpl<Company> implements CompanyRepository {

	public CompanyRepositoryImpl() {
		super(Company.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Types> types(Long id) {
		String sqlQuery = "SELECT c.types FROM Company c WHERE c.id = :id";
		@SuppressWarnings("deprecation")
		Query query = this.getSession().createQuery(sqlQuery).setParameter("id", id);
		return query.getResultList();
	}

}
