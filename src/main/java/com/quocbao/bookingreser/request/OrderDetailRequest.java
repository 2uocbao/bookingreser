package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class OrderDetailRequest {

	@JsonProperty("foodId")
	protected Long foodId;

	@JsonProperty("quantity")
	protected int quantity;
}
