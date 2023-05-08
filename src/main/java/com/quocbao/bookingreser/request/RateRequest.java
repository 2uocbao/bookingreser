package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class RateRequest {

	@JsonProperty("companyId")
	public Long companyId;

	@JsonProperty("userId")
	public Long userId;

	@JsonProperty("point")
	public int point;

	@JsonProperty("comment")
	public String comment;
}
