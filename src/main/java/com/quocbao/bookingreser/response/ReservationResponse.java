package com.quocbao.bookingreser.response;

import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Reservation;
import com.quocbao.bookingreser.request.ReservationRequest;

import lombok.Setter;

@Setter
public class ReservationResponse extends ReservationRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("employee_id")
	private Long employeeId;
	
	@JsonProperty("service_id")
	private Long serviceId;
	
	@JsonProperty("user_id")
	private Long userId;
	
	@JsonProperty("type")
	private Set<TypeResponse> typeReponse;
	
	@JsonProperty("created_at")
	private Timestamp createdAt;
	
	@JsonProperty("updated_at")
	private Timestamp updatedAt;
	
	public ReservationResponse(Reservation reservation) {
		this.id = reservation.getId();
		this.employeeId = reservation.getEmployee().getId();
		this.userId = reservation.getUser().getId();
		this.serviceId = reservation.getService().getId();
		this.checkinDate = reservation.getCheckinDate();
		this.note = reservation.getNote();
		this.deposit = reservation.getDeposit();
		this.createdAt = reservation.getCreatedAt();
		this.updatedAt = reservation.getUpdatedAt();
	}
}
