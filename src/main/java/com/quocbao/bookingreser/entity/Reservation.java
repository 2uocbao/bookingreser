package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.quocbao.bookingreser.request.ReservationRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

	@Column(name = "note")
	private String note;

	@Column(name = "deposit")
	private float deposit;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Timestamp createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "reservation_type", joinColumns = @JoinColumn(name = "reservation_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
	private Set<Types> types = new HashSet<>();

	public Reservation(ReservationRequest reservationRequest, Company company, Employee employee, Services service,
			User user) {
		this.company = company;
		this.employee = employee;
		this.user = user;
		this.service = service;
		this.checkinDate = reservationRequest.getCheckinDate();
		this.note = reservationRequest.getNote();
		this.deposit = reservationRequest.getDeposit();
	}

	public void setReservation(ReservationRequest reservationRequest, Employee employee, Services service) {
		this.employee = employee;
		this.service = service;
		this.checkinDate = reservationRequest.getCheckinDate();
		this.note = reservationRequest.getNote();
		this.deposit = reservationRequest.getDeposit();
	}
}
