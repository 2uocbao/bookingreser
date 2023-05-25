package com.quocbao.bookingreser.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class OrderRequest {
	
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
	
	@JsonProperty("order_detail")
	public List<OrderDetailRequest> orderDetailRequests;
}
