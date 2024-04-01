package com.quocbao.bookingreser.response;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.Reservation;

import lombok.Setter;

@Setter
public class ReservationResponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("employee")
	private EmployeeResponse employeeResponse;
	
	@JsonProperty("user")
	private UserResponse userResponse;
	
	@JsonProperty("tableId")
	private Long tableId;
	
	@JsonProperty("checkindate")
	protected Timestamp checkinDate;
	
	@JsonProperty("checkintime")
	protected Time checkinTime;

	@JsonProperty("note")
	protected String note;
	
	@JsonProperty("status")
	private String status;

	@JsonProperty("created_at")
	private Timestamp createdAt;

	@JsonProperty("updated_at")
	private Timestamp updatedAt;

	public ReservationResponse(Reservation reservation) {
		this.id = reservation.getId();
		this.employeeResponse = reservation.getEmployee() == null ? null : new EmployeeResponse(reservation.getEmployee());
		this.userResponse = new UserResponse(reservation.getUser());
		this.tableId = reservation.getService().getId();
		this.checkinDate = reservation.getCheckinDate();
		this.checkinTime = reservation.getCheckinTime();
		this.status = reservation.getStatus();
		this.createdAt = reservation.getCreatedAt();
		this.updatedAt = reservation.getUpdatedAt();
	}
	
	public ReservationResponse() {
		// TODO Auto-generated constructor stub
	}

	public List<ReservationResponse> reservationResponses(List<Reservation> reservations){
		return reservations.stream().map(ReservationResponse::new).toList();
	}
 }
