package com.quocbao.bookingreser.reponse;

import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.request.ReservationRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationReponse extends ReservationRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("company_id")
	private Long companyId;
	
	@JsonProperty("employee_id")
	private Long employeeId;
	
	@JsonProperty("service_id")
	private Long serviceId;
	
	@JsonProperty("user_id")
	private Long userId;
	
	@JsonProperty("type")
	private Set<TypeReponse> typeReponse;
	
	@JsonProperty("created_at")
	private Timestamp createdAt;
	
	@JsonProperty("updated_at")
	private Timestamp updatedAt;
}
