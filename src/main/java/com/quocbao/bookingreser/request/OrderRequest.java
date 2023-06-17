package com.quocbao.bookingreser.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class OrderRequest {

	@JsonProperty("serviceId")
	protected Long serviceId;

	@JsonProperty("employeeId")
	protected Long employeeId;

	@JsonProperty("userId")
	protected Long userId;

	@JsonProperty("description")
	protected String description;

	@JsonProperty("order_detail")
	public List<OrderDetailRequest> orderDetailRequests;
}
