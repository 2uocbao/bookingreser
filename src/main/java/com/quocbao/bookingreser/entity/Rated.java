package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.quocbao.bookingreser.request.RateRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "rated")
@DynamicUpdate
@NoArgsConstructor
public class Rated implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "point")
	private int point;
	
	@Column(name = "comment")
	private String comment;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Timestamp createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	// relationship
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;
	
	public Rated(RateRequest rateRequest, Company company, User user) {
		this.company = company;
		this.user = user;
		this.point = rateRequest.getPoint();
		this.comment = rateRequest.getComment();
	}
	
	public void  setRated(RateRequest rateRequest) {
		this.point = rateRequest.getPoint();
		this.comment = rateRequest.getComment();
	}
}
