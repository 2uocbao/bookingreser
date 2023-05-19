package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.repository.TypeRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class TypeRepositoryImpl extends RepositoryImpl<Types> implements TypeRepository {

	protected TypeRepositoryImpl() {
		super(Types.class);
	}

	@Override
	public List<Types> types(String type) {
		CriteriaBuilder builder = this.getCriteriaBuilder();
		CriteriaQuery<Types> criteriaQuery = builder.createQuery(Types.class);
		Root<Types> root = criteriaQuery.from(Types.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("type"), type));
		return this.getSession().createQuery(criteriaQuery).getResultList();
	}
}
