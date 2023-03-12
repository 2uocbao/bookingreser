package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.OrderDetail;

public interface OrderDetailRepository {
	
	public OrderDetail createOrderDetail(OrderDetail orderDetail);
	
	public List<OrderDetail> listOrderDetailByOrderId(Long orderId);
	
	public OrderDetail updateOrderDetail(OrderDetail orderDetail);
}
