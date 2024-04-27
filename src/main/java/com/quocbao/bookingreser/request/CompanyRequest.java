package com.quocbao.bookingreser.request;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class CompanyRequest {
	
	@JsonProperty("id")
	protected Long id;
	
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
	protected AddressRequest addressRequest;

	@JsonProperty("status")
	protected String status;

	@JsonProperty("createdAt")
	protected Timestamp createdAt;

	@JsonProperty("updateAt")
	protected Timestamp updatedAt;
}
