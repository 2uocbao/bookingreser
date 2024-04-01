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
	protected String name;
	
	@JsonProperty("status")
	protected String status;

	public ServiceResponse(Services service) {
		this.id = service.getId();
		this.name = service.getName();
		this.status = service.getStatus();
	}

	public List<ServiceResponse> serviceResponses(List<Services> Services ) {
		return Services.stream().map(ServiceResponse::new).toList();
	}

	public ServiceResponse() {

	}
}
