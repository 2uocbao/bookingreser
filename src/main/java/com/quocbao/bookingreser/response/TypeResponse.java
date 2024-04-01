package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Types;

import lombok.Setter;

@Setter
public class TypeResponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	protected String name;

	public TypeResponse(Types types) {
		this.id = types.getId();
		this.name = types.getName();
	}

	public TypeResponse() {

	}

	public List<TypeResponse> typeResponses(List<Types> types) {
		return types.stream().map(TypeResponse::new).toList();
	}
}
