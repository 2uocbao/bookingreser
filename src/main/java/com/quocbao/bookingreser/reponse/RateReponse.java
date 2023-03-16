package com.quocbao.bookingreser.reponse;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.request.RateRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RateReponse extends RateRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("company_id")
	private Long companyId;
	
	@JsonProperty("service_id")
	private Long serviceId;
	
	@JsonProperty("employee_id")
	private Long employeeId;
	
	@JsonProperty("user_id")
	private Long userId;
	
	@JsonProperty("Type")
	private Set<TypeReponse> typeReponses;
}
