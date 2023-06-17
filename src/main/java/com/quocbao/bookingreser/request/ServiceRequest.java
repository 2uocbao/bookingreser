package com.quocbao.bookingreser.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceRequest {

	@JsonProperty("companyId")
	protected Long companyId;

	@JsonProperty("name")
	protected String name;

	@JsonProperty("type")
	protected List<String> types;
}
