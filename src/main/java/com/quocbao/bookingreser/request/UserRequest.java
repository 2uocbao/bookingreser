package com.quocbao.bookingreser.request;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class UserRequest {
	
	@JsonProperty("id")
	protected Long id;

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

	@JsonProperty("email")
	protected String email;
	
	@JsonProperty("phone")
	protected String phone;

	@JsonProperty("address")
	protected AddressRequest addressRequest;
	
	@JsonProperty("created_at")
	protected Timestamp createdAt;
	
	@JsonProperty("updated_at")
	protected Timestamp updatedAt;
}
