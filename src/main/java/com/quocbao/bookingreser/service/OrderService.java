package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.OrderRequest;
import com.quocbao.bookingreser.response.OrderResponse;

public interface OrderService {

	public void createOrder(OrderRequest orderRequest);

	public OrderResponse detailOrder(Long id);

	public void updateOrder(OrderRequest orderRequest);

	public List<OrderResponse> listOrderByCompanyId(Long companyId);

	public List<OrderResponse> listOrderByUserId(Long userId);

	public void uStatus(Long id, String status);

	public void uStatusOrderDetails(Long orderDetailId, String status);

	public OrderResponse payOrder(Long id);
}
