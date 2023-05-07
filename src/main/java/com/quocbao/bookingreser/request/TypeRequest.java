package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class TypeRequest {

	@JsonProperty("type_id")
	public Long typeId;
}
