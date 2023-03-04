package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmpUserRequest {

	@JsonProperty("lastname")
	private String lastName;
	
	@JsonProperty("firstname")
	private String firstName;
	
	@JsonProperty("dateofbirth")
	private String dateofBirth;
	
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
