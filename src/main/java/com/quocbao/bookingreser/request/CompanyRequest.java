package com.quocbao.bookingreser.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class CompanyRequest {

	@JsonProperty("name")
	protected String name;

	@JsonProperty("email")
	protected String email;

	@JsonProperty("phone")
	protected String phone;

	@JsonProperty("image")
	protected String image;

	@JsonProperty("infor")
	protected String infor;

	@JsonProperty("address")
	protected String address;

	@JsonProperty("type")
	protected List<Long> types;
}
