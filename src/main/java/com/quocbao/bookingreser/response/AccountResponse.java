package com.quocbao.bookingreser.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class AccountResponse {

	@JsonProperty("access_token")
	private String accessToken;
}
