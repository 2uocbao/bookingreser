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
	protected String lastName;

	@JsonProperty("firstname")
	protected String firstName;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("address")
	private AddressResponse addressResponse;

	@JsonProperty("dateofbirth")
	protected Date dateofBirth;

	@JsonProperty("gender")
	protected String gender;

	@JsonProperty("image")
	protected String image;
	

	public UserResponse(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.dateofBirth = user.getDateofBirth();
		this.phone = user.getPhone();
		this.gender = user.getGender();
		this.image = user.getImage();
		this.addressResponse = new AddressResponse(user.getAddress());
	}
}
