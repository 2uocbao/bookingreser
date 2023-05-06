package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.OrderDetail;
import com.quocbao.bookingreser.repository.OrderDetailRepository;

@Repository
public class OrderDetailRepositoryImpl extends RepositoryImpl<OrderDetail> implements OrderDetailRepository {

	protected OrderDetailRepositoryImpl() {
		super(OrderDetail.class);
	}

}
