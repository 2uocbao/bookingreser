package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.OrderDetail;
import com.quocbao.bookingreser.repository.OrderDetailRepository;

@Repository
public class OrderDetailRepositoryImpl extends AbstractRepository<OrderDetail> implements OrderDetailRepository {

	@Override
	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
		return this.create(orderDetail);
	}

	@Override
	public List<OrderDetail> listOrderDetailByOrderId(Long orderId) {
		return this.listOrderDetailByOrderId(orderId);
	}

	@Override
	public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
		return this.update(orderDetail);
	}
}
