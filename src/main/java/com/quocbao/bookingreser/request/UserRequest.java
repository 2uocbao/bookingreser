package com.quocbao.bookingreser.request;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class UserRequest {

	@JsonProperty("lastname")
	private String lastName;

	@JsonProperty("firstname")
	private String firstName;

	@JsonProperty("dateofbirth")
	private Date dateofBirth;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("image")
	private String image;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("email")
	private String email;

	@JsonProperty("address")
	private String address;
}