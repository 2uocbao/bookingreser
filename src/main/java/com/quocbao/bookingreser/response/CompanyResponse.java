package com.quocbao.bookingreser.response;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.request.AddressRequest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompanyResponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	protected String name;

	@JsonProperty("email")
	protected String email;

	@JsonProperty("phone")
	protected String phone;

	@JsonProperty("image")
	protected String image;

	@JsonProperty("infor")
	protected String infor;

	@JsonProperty("address")
	protected AddressRequest addressRequest;

	@JsonProperty("status")
	protected String status;

	@JsonProperty("createdAt")
	protected Timestamp createdAt;

	@JsonProperty("updateAt")
	protected Timestamp updatedAt;
	
	public CompanyResponse() {
		
	}

	public CompanyResponse(Company company) {
		this.id = company.getId();
		this.name = company.getName();
		this.addressRequest = new AddressResponse(company.getAddress());
		this.email = company.getEmail();
		this.phone = company.getPhone();
		this.image = company.getImage();
		this.infor = company.getInfor();
		this.status = company.getStatus();
		this.createdAt = company.getCreatedAt();
		this.updatedAt = company.getUpdatedAt();
	}
	
	public List<CompanyResponse> companyResponses(List<Company> companies){
		return companies.stream().map(CompanyResponse::new).toList();
	}
}
