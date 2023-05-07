package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class RateRequest {

	@JsonProperty("point")
	public int point;
	
	@JsonProperty("comment")
	public String comment;
}
