package com.quocbao.bookingreser.response;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.User;

import lombok.Setter;

@Setter
public class UserResponse {

	@JsonProperty("id")
	private Long id;

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

	public UserResponse(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.dateofBirth = user.getDateofBirth();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.gender = user.getGender();
		this.image = user.getEmail();
	}
}
