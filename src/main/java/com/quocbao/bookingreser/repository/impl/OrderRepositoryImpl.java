package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.entity.Services;
import com.quocbao.bookingreser.entity.metamodel.Order_;
import com.quocbao.bookingreser.entity.metamodel.Services_;
import com.quocbao.bookingreser.repository.OrderRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class OrderRepositoryImpl extends RepositoryImpl<Order> implements OrderRepository {

	protected OrderRepositoryImpl() {
		super(Order.class);
	}

	@Override
	public Order orderByServiceId(Long serviceId) {
		CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
		CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
		Root<Order> root = criteriaQuery.from(Order.class);
		Join<Order, Services> join = root.join(Order_.SERVICEID, JoinType.INNER);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(join.get(Services_.ID), serviceId));
		return getSession().createQuery(criteriaQuery).getSingleResult();
	}

}
