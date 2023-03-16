package com.quocbao.bookingreser.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEmployeeInfor {
	
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
