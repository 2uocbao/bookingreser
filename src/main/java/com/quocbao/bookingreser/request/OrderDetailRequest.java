package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class OrderDetailRequest {

	@JsonProperty("foodId")
	public Long foodId;

	@JsonProperty("quantity")
	public float quantity;
}
