package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.entity.OrderDetail;
import com.quocbao.bookingreser.request.OrderDetailRequest;
import com.quocbao.bookingreser.request.OrderRequest;

public interface OrderService {

	// Order
	public void createOrder(OrderRequest orderRequest);

	public Order detailOrder(Long id);

	public void updateOrder(Long id, OrderRequest orderRequest);

	public List<Order> listOrderByCompanyId(Long companyId);

	public List<Order> listOrderByUserId(Long userId);

	public void uStatus(Long id, int value);

	public Order payOrder(Long id);

	// OrderDetail
	public void createOrderDetail(OrderDetailRequest orderDetailRequest);

	public List<OrderDetail> orderDetails(Long orderId);

	public void updateOrderDetail(Long id, OrderDetailRequest orderDetailRequest);

	public void uStatusOrderDetail(Long id);
}
