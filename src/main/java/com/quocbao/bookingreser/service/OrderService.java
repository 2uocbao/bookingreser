package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.request.OrderRequest;
import com.quocbao.bookingreser.response.OrderResponse;

public interface OrderService {

	public void createOrder(OrderRequest orderRequest);

	public OrderResponse detailOrder(Long id);

	public void updateOrder(Long id, OrderRequest orderRequest);

	public List<OrderResponse> listOrderByCompanyId(Long companyId);

	public List<OrderResponse> listOrderByUserId(Long userId);

	public void uStatus(Long id, String status);

	public Order payOrder(Long id);
}
