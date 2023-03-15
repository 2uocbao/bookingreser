package com.quocbao.bookingreser.reponse;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyReponse {
	
	@JsonProperty("id")
	private Long id;

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
	private Set<String> types;
}
