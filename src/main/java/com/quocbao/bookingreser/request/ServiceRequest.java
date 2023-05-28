package com.quocbao.bookingreser.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ServiceRequest {

	@JsonProperty("companyId")
	private Long companyId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("type")
	private List<Long> type;
}
