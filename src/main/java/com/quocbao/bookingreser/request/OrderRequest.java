package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class OrderRequest {

	@JsonProperty("serviceId")
	protected Long serviceId;

	@JsonProperty("employeeId")
	protected Long employeeId;
}
