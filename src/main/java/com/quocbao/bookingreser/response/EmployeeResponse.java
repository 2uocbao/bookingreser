package com.quocbao.bookingreser.response;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Employee;

import lombok.Setter;

@Setter
public class EmployeeResponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("lastname")
	protected String lastName;

	@JsonProperty("firstname")
	protected String firstName;
	
	@JsonProperty("address")
	protected AddressResponse addressResponse;

	@JsonProperty("dateofbirth")
	protected Date dateofBirth;

	@JsonProperty("gender")
	protected String gender;

	@JsonProperty("image")
	protected String image;

	@JsonProperty("email")
	protected String email;

	@JsonProperty("kpa")
	private int kpa;

	@JsonProperty("createdAt")
	private Timestamp createdAt;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("company")
	private CompanyResponse companyResponse;

	public EmployeeResponse(Employee employee) {
		this.id = employee.getId();
		this.companyResponse = new CompanyResponse(employee.getCompany());
		this.lastName = employee.getLastName();
		this.firstName = employee.getFirstName();
		this.dateofBirth = employee.getDateofBirth();
		this.gender = employee.getGender();
		this.image = employee.getImage();
		this.phone = employee.getPhone();
		this.email = employee.getEmail();
		this.addressResponse = new AddressResponse(employee.getAddress());
		this.kpa = employee.getKpa();
		this.createdAt = employee.getCreatedAt();
	}

	public List<EmployeeResponse> employeeResponses(List<Employee> employes) {
		return employes.stream().map(EmployeeResponse::new).toList();
	}

	public EmployeeResponse() {

	}
}
