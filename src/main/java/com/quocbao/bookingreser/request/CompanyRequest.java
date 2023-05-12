package com.quocbao.bookingreser.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class CompanyRequest {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("infor")
	private String infor;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("type")
	private List<Long> types;
}
