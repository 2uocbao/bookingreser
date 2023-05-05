package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.common.UserEmployeeInfor;
import com.quocbao.bookingreser.entity.Employee;

import lombok.Setter;

@Setter
public class EmployeeResponse extends UserEmployeeInfor {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("kpa")
	private int kpa;

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
	}

	public List<EmployeeResponse> employeeResponses(List<Employee> employes) {
		return employes.stream().map(EmployeeResponse::new).toList();
	}

	public EmployeeResponse() {

	}
}
