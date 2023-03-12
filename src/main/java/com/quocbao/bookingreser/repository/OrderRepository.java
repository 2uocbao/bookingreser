package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.Order;

public interface OrderRepository {

	public Order createOrder(Order order);
	
	public Order detailOrder(Long id);
	
	public Order updateOrder(Order order);
	
	public List<Order> listOrderByCompanyId(Long companyId);
	
	public List<Order> listOrderByUserId(Long userId);
	
	public List<Order> listOrderByEmployeeId(Long employeeId);
}
