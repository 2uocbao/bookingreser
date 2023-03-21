package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.quocbao.bookingreser.request.ReservationRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Reservation")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "checkin_date")
	private Timestamp checkinDate;

	@Column(name = "note")
	private String note;

	@Column(name = "deposit")
	private float deposit;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service_id", referencedColumnName = "id")
	private Service service;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	public Reservation(ReservationRequest reservationRequest, Employee employee, Service service, User user) {
		this.employee = employee;
		this.user = user;
		this.service = service;
		this.checkinDate = reservationRequest.getCheckinDate();
		this.note = reservationRequest.getNote();
		this.deposit = reservationRequest.getDeposit();
	}
}
