package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class TypeRequest {

	@JsonProperty("name")
	protected String name;

	@JsonProperty("type")
	protected String type;
}
