package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class AddressRequest {

	@JsonProperty("aparment_number")
	protected String aparmentNumber;
	
	@JsonProperty("road")
	protected String road;
	
	@JsonProperty("ward")
	protected String ward;
	
	@JsonProperty("district")
	protected String district;
	
	@JsonProperty("province")
	protected String province;
}
