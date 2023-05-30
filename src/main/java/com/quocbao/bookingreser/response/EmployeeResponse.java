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

	@JsonProperty("companyId")
	private Long companyId;

	@JsonProperty("lastname")
	private String lastName;

	@JsonProperty("firstname")
	private String firstName;

	@JsonProperty("dateofbirth")
	private Date dateofBirth;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("image")
	private String image;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("email")
	private String email;

	@JsonProperty("address")
	private String address;

	@JsonProperty("kpa")
	private int kpa;

	@JsonProperty("createdAt")
	private Timestamp createdAt;

	public EmployeeResponse(Employee employee) {
		this.id = employee.getId();
		this.companyId = employee.getCompany().getId();
		this.lastName = employee.getLastName();
		this.firstName = employee.getFirstName();
		this.dateofBirth = employee.getDateofBirth();
		this.gender = employee.getGender();
		this.image = employee.getImage();
		this.phone = employee.getPhone();
		this.email = employee.getEmail();
		this.address = employee.getAddress();
		this.kpa = employee.getKpa();
		this.createdAt = employee.getCreatedAt();
	}

	public List<EmployeeResponse> employeeResponses(List<Employee> employes) {
		return employes.stream().map(EmployeeResponse::new).toList();
	}

	public EmployeeResponse() {

	}
}
