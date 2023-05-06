package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl extends RepositoryImpl<Order> implements OrderRepository {

	protected OrderRepositoryImpl() {
		super(Order.class);
	}

}
