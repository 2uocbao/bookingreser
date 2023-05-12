package com.quocbao.bookingreser.response;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Company;

import lombok.Setter;

@Setter
public class CompanyResponse {

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

	@JsonProperty("status")
	private int status;

	@JsonProperty("type")
	private List<String> types;

	@JsonProperty("createdAt")
	private Timestamp createdAt;

	@JsonProperty("updateAt")
	private Timestamp updatedAt;

	public CompanyResponse(Company company) {
		this.id = company.getId();
		this.name = company.getName();
		this.email = company.getEmail();
		this.phone = company.getPhone();
		this.image = company.getImage();
		this.infor = company.getInfor();
		this.address = company.getAddress();
		this.status = company.getStatus();
		this.createdAt = company.getCreatedAt();
		this.updatedAt = company.getUpdatedAt();
	}
}
