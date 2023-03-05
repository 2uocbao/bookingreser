package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountRequest {

	@JsonProperty("username")
	private String username;
	
	@JsonProperty("password")
	private String password;
}
