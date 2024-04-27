package com.quocbao.bookingreser.response;

import java.util.List;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.request.CompanyRequest;

import lombok.Setter;

@Setter
public class CompanyResponse extends CompanyRequest{
	
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
