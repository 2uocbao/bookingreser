package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class AddressRequest {
	
	@JsonProperty("id")
	protected Long id;

	@JsonProperty("aparment_number")
	protected String aparmentNumber;
	
	@JsonProperty("street")
	protected String street;
	
	@JsonProperty("ward")
	protected String ward;
	
	@JsonProperty("district")
	protected String district;
	
	@JsonProperty("province")
	protected String province;
}
