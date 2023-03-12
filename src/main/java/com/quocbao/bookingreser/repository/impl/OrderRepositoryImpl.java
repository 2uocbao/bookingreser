package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl extends AbstractRepository<Order> implements OrderRepository {

	@Override
	public Order createOrder(Order order) {
		return this.create(order);
	}

	@Override
	public Order detailOrder(Long id) {
		return this.detail(id);
	}

	@Override
	public Order updateOrder(Order order) {
		return this.update(order);
	}

	@Override
	public List<Order> listOrderByCompanyId(Long companyId) {
		return this.listOrderByCompanyId(companyId);
	}

	@Override
	public List<Order> listOrderByUserId(Long userId) {
		return this.listOrderByUserId(userId);
	}

	@Override
	public List<Order> listOrderByEmployeeId(Long employeeId) {
		return this.listOrderByEmployeeId(employeeId);
	}

}
