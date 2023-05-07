package com.quocbao.bookingreser.response;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.request.OrderRequest;

import lombok.Setter;

@Setter
public class OrderResponse extends OrderRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("company_id")
	private Long companyId;
	
	@JsonProperty("employee_id")
	private Long employeeId;
	
	@JsonProperty("user_id")
	private Long userId;
	
	@JsonProperty("service_id")
	private Long serviceId;
	
	@JsonProperty("total_amount")
	private float totalAmount;
	
	@JsonProperty("status")
	private int status;
	
	@JsonProperty("created_at")
	private Timestamp createdAt;
	
	@JsonProperty("updated_at")
	private Timestamp updatedAt;
	
	public OrderResponse(Order order) {
		this.id = order.getId();
		this.companyId = order.getCompany().getId();
		this.employeeId = order.getEmployee().getId();
		this.userId = order.getUser().getId();
		this.serviceId = order.getService().getId();
		this.description = order.getDescription();
		this.totalAmount = order.getTotalAmount();
		this.status = order.getStatus();
		this.createdAt = order.getCreatedAt();
		this.updatedAt = order.getUpdatedAt();
	}
}
