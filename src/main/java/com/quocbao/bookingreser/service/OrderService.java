package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.request.OrderRequest;

public interface OrderService {

	public void createOrder(OrderRequest orderRequest);

	public Order detailOrder(Long id);

	public void updateOrder(Long id, OrderRequest orderRequest);

	public List<Order> listOrderByCompanyId(Long companyId);

	public List<Order> listOrderByUserId(Long userId);
}
