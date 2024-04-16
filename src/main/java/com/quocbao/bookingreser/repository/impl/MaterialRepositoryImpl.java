package com.quocbao.bookingreser.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.metamodel.Company_;
import com.quocbao.bookingreser.entity.metamodel.Material_;
import com.quocbao.bookingreser.repository.MaterialRepository;

import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MaterialRepositoryImpl extends RepositoryImpl<Material> implements MaterialRepository {

	protected MaterialRepositoryImpl() {
		super(Material.class);
	}

	@Override
	public List<Material> materials(Long companyId) {
		CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
		Root<Material> root = criteriaQuery.from(Material.class);
		Join<Company, Material> join = root.join(Material_.COMPANY, JoinType.INNER);
		criteriaQuery.multiselect(root.get(Material_.ID), root.get(Material_.CODE), root.get(Material_.NAME), root.get(Material_.STATUS));
		criteriaQuery.where(criteriaBuilder.equal(join.get(Company_.ID), companyId));
		List<Tuple> tuples = getSession().createQuery(criteriaQuery).getResultList();
		List<Material> materials = new ArrayList<>();
		for(Tuple tuple : tuples) {
			materials.add(new Material((long) tuple.get(0), (String) tuple.get(1), (String) tuple.get(2), (String) tuple.get(3)));
		}
		return materials;
	}

	@Override
	public Long checkValueExist(Long companyId, String code) {
		CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Material> root = criteriaQuery.from(Material.class);
		Join<Company, Material> join = root.join(Material_.COMPANY, JoinType.INNER);
		criteriaQuery.select(root.get(Material_.ID));
		criteriaQuery.where(criteriaBuilder.equal(root.get(Material_.CODE), code), criteriaBuilder.equal(join.get(Company_.ID), companyId));
		Long id = getSession().createQuery(criteriaQuery).uniqueResult();
		if(id == null) {
			id = (long) 0;
		}
		System.out.println(id);
		return id;
	}
}
