package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.quocbao.bookingreser.request.ReservationRequest;
import com.quocbao.bookingreser.util.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "reservation")
@DynamicUpdate
@NoArgsConstructor
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "checkin_date")
	private Timestamp checkinDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "checkin_time")
	private Time checkinTime;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at")
	private Timestamp createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_at")
	private Timestamp updatedAt;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "service_id", referencedColumnName = "id")
	private Services service;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;
	
	public Reservation(ReservationRequest reservationRequest, Services service,
			User user, Company company) {
		this.user = user;
		this.service = service;
		this.company = company;
		this.checkinDate = reservationRequest.getCheckinDate();
		this.checkinTime = reservationRequest.getCheckinTime();
		this.status = Status.UNCONFIRMED.toString();
	}

	public void setReservation(ReservationRequest reservationRequest, Employee employee, Services service) {
		this.employee = employee;
		this.service = service;
		this.checkinDate = reservationRequest.getCheckinDate();
		this.checkinTime = reservationRequest.getCheckinTime();
	}
}
