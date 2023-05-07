package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class AccountRequest {

	@JsonProperty("username")
	private String username;
	
	@JsonProperty("password")
	private String password;
}
