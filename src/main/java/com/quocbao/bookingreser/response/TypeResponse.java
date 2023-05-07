package com.quocbao.bookingreser.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.request.TypeRequest;

import lombok.Setter;

@Setter
public class TypeResponse extends TypeRequest{
	
	@JsonProperty("name")
	private String name;
	
	public TypeResponse(Types types) {
		this.typeId = types.getId();
		this.name = types.getName();
	}
}
