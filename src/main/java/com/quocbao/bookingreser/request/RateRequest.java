package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class RateRequest {

	@JsonProperty("companyId")
	protected Long companyId;

	@JsonProperty("userId")
	protected Long userId;

	@JsonProperty("point")
	protected int point;

	@JsonProperty("comment")
	protected String comment;
}
