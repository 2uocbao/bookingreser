package com.quocbao.bookingreser.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Rated;
import com.quocbao.bookingreser.request.RateRequest;

import lombok.Setter;

@Setter
public class RateResponse extends RateRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("company_id")
	private Long companyId;
	
	@JsonProperty("user_id")
	private Long userId;
	
	public RateResponse(Rated rated) {
		this.id = rated.getId();
		this.companyId = rated.getCompany().getId();
		this.userId = rated.getUser().getId();
		this.point = rated.getPoint();
		this.comment = rated.getComment();
	}
}
