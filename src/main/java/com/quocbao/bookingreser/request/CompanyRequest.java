package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class CompanyRequest {

	@JsonProperty("name")
	protected String name;

	@JsonProperty("email")
	protected String email;

	@JsonProperty("image")
	protected String image;

	@JsonProperty("infor")
	protected String infor;

	@JsonProperty("address")
	protected AddressRequest addressRequest;
}
