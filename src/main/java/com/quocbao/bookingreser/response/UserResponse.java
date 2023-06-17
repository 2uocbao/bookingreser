package com.quocbao.bookingreser.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.request.UserRequest;

import lombok.Setter;

@Setter
public class UserResponse extends UserRequest{

	@JsonProperty("id")
	private Long id;

	public UserResponse(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.dateofBirth = user.getDateofBirth();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.gender = user.getGender();
		this.image = user.getEmail();
		this.address = user.getAddress();
	}
}
