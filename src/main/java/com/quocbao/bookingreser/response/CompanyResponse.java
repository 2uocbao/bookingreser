package com.quocbao.bookingreser.response;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.request.AddressRequest;

import lombok.Setter;

@Setter
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
	private String status;

	@JsonProperty("createdAt")
	private Timestamp createdAt;

	@JsonProperty("updateAt")
	private Timestamp updatedAt;
	
	@JsonProperty("table")
	private List<ServiceResponse> serviceResponses;
	
	@JsonProperty("food")
	private List<FoodResponse> foodResponses;
	
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
		this.serviceResponses = new ServiceResponse().serviceResponses(company.getServices());
		this.foodResponses = new FoodResponse().foodResponses(company.getFoods());
	}
	
	public List<CompanyResponse> companyResponses(List<Company> companies){
		return companies.stream().map(CompanyResponse::new).toList();
	}
}
