package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
public class EmployeeRequest extends UserRequest {

	@JsonProperty("companyId")
	protected Long companyId;
	
	@JsonProperty("KPA")
	protected int kpa;
}
