package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Services;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.request.ServiceRequest;

import lombok.Setter;

@Setter
public class ServiceResponse extends ServiceRequest{

	@JsonProperty("id")
	private Long id;

	public ServiceResponse(Services services) {
		this.id = services.getId();
		this.name = services.getName();
		this.types = services.getTypes().stream().map(Types::getName).toList();
	}

	public List<ServiceResponse> serviceResponses(List<Services> services) {
		return services.stream().map(ServiceResponse::new).toList();
	}

	public ServiceResponse() {

	}
}
