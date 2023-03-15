package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RateRequest {

	@JsonProperty("point")
	private int point;
	
	@JsonProperty("comment")
	private String comment;
}
