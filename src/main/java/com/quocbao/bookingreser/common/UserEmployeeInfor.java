package com.quocbao.bookingreser.common;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserEmployeeInfor {
	
	@JsonProperty("lastname")
	public String lastName;
	
	@JsonProperty("firstname")
	public String firstName;
	
	@JsonProperty("dateofbirth")
	public Date dateofBirth;
	
	@JsonProperty("gender")
	public String gender;
	
	@JsonProperty("image")
	public String image;
	
	@JsonProperty("phone")
	public String phone;
	
	@JsonProperty("email")
	public String email;
	
	@JsonProperty("address")
	public String address;
}
