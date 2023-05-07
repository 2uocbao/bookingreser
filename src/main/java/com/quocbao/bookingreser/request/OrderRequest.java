package com.quocbao.bookingreser.request;

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
}
