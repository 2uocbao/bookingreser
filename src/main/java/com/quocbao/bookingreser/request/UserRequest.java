package com.quocbao.bookingreser.request;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class UserRequest {

	@JsonProperty("lastname")
	protected String lastName;

	@JsonProperty("firstname")
	protected String firstName;

	@JsonProperty("dateofbirth")
	protected Date dateofBirth;

	@JsonProperty("gender")
	protected String gender;

	@JsonProperty("image")
	protected String image;

	@JsonProperty("phone")
	protected String phone;

	@JsonProperty("email")
	protected String email;

	@JsonProperty("address")
	protected String address;
}
