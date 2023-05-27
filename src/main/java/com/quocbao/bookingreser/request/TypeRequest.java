package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class TypeRequest {

	@JsonProperty("name")
	public String name;

	@JsonProperty("type")
	public String type;
}
