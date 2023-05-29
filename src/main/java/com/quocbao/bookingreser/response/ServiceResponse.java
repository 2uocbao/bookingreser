package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Services;

import lombok.Setter;

@Setter
public class ServiceResponse {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("type")
	private List<String> types;

	public ServiceResponse(Services services) {
		this.id = services.getId();
		this.name = services.getName();
	}

	public List<ServiceResponse> serviceResponses(List<Services> services) {
		return services.stream().map(ServiceResponse::new).toList();
	}

	public ServiceResponse() {

	}
}
