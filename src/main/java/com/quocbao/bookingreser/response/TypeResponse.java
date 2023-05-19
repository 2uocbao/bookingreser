package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.request.TypeRequest;

import lombok.Setter;

@Setter
public class TypeResponse extends TypeRequest{

	@JsonProperty("id")
	private Long id;
	
	public TypeResponse(Types types) {
		this.id = types.getId();
		this.name = types.getName();
	}

	public TypeResponse() {

	}

	public List<TypeResponse> typeResponses(List<Types> types){
		return types.stream().map(TypeResponse::new).toList();
	}
}
