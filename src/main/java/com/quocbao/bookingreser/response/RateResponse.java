package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Rated;
import com.quocbao.bookingreser.request.RateRequest;

import lombok.Setter;

@Setter
public class RateResponse extends RateRequest {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("user")
	private String user;

	public RateResponse(Rated rated) {
		this.id = rated.getId();
		this.companyId = rated.getCompany().getId();
		this.userId = rated.getUser().getId();
		this.user = rated.getUser().getLastName() + rated.getUser().getFirstName();
		this.point = rated.getPoint();
		this.comment = rated.getComment();
	}
	
	public RateResponse() {
		
	}
	
	public List<RateResponse> rateResponses(List<Rated> rateds){
		return rateds.stream().map(RateResponse::new).toList();
	}
}
