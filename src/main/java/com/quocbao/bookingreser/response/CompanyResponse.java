package com.quocbao.bookingreser.response;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.request.CompanyRequest;

import lombok.Setter;

@Setter
public class CompanyResponse extends CompanyRequest{

	@JsonProperty("id")
	private Long id;

	@JsonProperty("status")
	private String status;

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
		this.types = company.getTypes().stream().map(Types::getName).toList();
		this.createdAt = company.getCreatedAt();
		this.updatedAt = company.getUpdatedAt();
	}
}
