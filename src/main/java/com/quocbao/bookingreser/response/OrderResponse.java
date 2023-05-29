package com.quocbao.bookingreser.response;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Order;

import lombok.Setter;

@Setter
public class OrderResponse {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("companyId")
	public Long companyId;

	@JsonProperty("serviceId")
	public Long serviceId;

	@JsonProperty("employeeId")
	public Long employeeId;

	@JsonProperty("userId")
	public Long userId;

	@JsonProperty("description")
	public String description;

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
		OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
		this.id = order.getId();
		this.companyId = order.getCompany().getId();
		this.employeeId = order.getEmployee().getId();
		this.userId = order.getUser() == null ? null : order.getUser().getId();
		this.serviceId = order.getService().getId();
		this.description = order.getDescription();
		this.totalAmount = order.getTotalAmount();
		this.status = order.getStatus();
		this.createdAt = order.getCreatedAt();
		this.updatedAt = order.getUpdatedAt();
		this.orderDetailResponses = orderDetailResponse.orderDetailResponses(order.getOrderDetails());
	}

	public List<OrderResponse> orderResponses(List<Order> orders) {
		return orders.stream().map(OrderResponse::new).toList();
	}
}
