package com.quocbao.bookingreser.response;

import java.util.List;

import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.request.EmployeeRequest;

import lombok.Setter;

@Setter
public class EmployeeResponse extends EmployeeRequest{
	
	public EmployeeResponse(Employee employee) {
		this.id = employee.getId();
		this.companyId = employee.getCompany() != null ? employee.getCompany().getId() : 0;
		this.lastName = employee.getLastName();
		this.firstName = employee.getFirstName();
		this.dateofBirth = employee.getDateofBirth();
		this.gender = employee.getGender();
		this.image = employee.getImage();
		this.phone = employee.getPhone();
		this.email = employee.getEmail();
		this.addressRequest = employee.getAddress() != null ? new AddressResponse(employee.getAddress()) : null;
		this.kpa = employee.getKpa();
		this.createdAt = employee.getCreatedAt();
		this.updatedAt = employee.getUpdatedAt();
	}

	public List<EmployeeResponse> employeeResponses(List<Employee> employes) {
		return employes.stream().map(EmployeeResponse::new).toList();
	}

	public EmployeeResponse() {

	}
}
