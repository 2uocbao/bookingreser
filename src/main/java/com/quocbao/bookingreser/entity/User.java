package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.quocbao.bookingreser.request.UserRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@DynamicUpdate
@NoArgsConstructor
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "dateof_birth")
	private Date dateofBirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "image")
	private String image;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "status")
	private String status;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Timestamp createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	public User(UserRequest userRequest) {
		this.firstName = userRequest.getFirstName();
		this.lastName = userRequest.getLastName();
		this.dateofBirth = userRequest.getDateofBirth();
		this.gender = userRequest.getGender();
		this.image = userRequest.getImage();
		this.phone = userRequest.getPhone();
		this.email = userRequest.getEmail();
		this.address = userRequest.getAddress();
	}

	public void setUser(UserRequest userRequest) {
		this.firstName = userRequest.getFirstName();
		this.lastName = userRequest.getLastName();
		this.dateofBirth = userRequest.getDateofBirth();
		this.gender = userRequest.getGender();
		this.image = userRequest.getImage();
		this.phone = userRequest.getPhone();
		this.email = userRequest.getEmail();
		this.address = userRequest.getAddress();
	}
}
