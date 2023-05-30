package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class EmployeeRequest extends UserRequest {

	@JsonProperty("companyId")
	private Long companyId;
}