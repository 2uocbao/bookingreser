package com.quocbao.bookingreser.response;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.request.OrderRequest;

import lombok.Setter;

@Setter
public class OrderResponse extends OrderRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("employee")
	private EmployeeResponse employeeResponse;
	
	@JsonProperty("table")
	private ServiceResponse serviceResponse;

	@JsonProperty("total_amount")
	private float totalAmount;

	@JsonProperty("status")
	private String status;

	@JsonProperty("created_at")
	private Timestamp createdAt;

	@JsonProperty("updated_at")
	private Timestamp updatedAt;

	@JsonProperty("order_detail")
	private List<OrderDetailResponse> orderDetailResponses;

	public OrderResponse() {

	}

	public OrderResponse(Order order) {
		this.id = order.getId();
		this.employeeResponse = new EmployeeResponse(order.getEmployee());
		this.serviceResponse = new ServiceResponse(order.getService());
		this.totalAmount = order.getTotalAmount();
		this.status = order.getStatus();
		this.createdAt = order.getCreatedAt();
		this.updatedAt = order.getUpdatedAt();
		this.orderDetailResponses = new OrderDetailResponse().orderDetailResponses(order.getOrderDetails());
	}

	public List<OrderResponse> orderResponses(List<Order> orders) {
		return orders.stream().map(OrderResponse::new).toList();
	}
}
