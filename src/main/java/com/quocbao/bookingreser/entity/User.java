package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.DynamicUpdate;

import com.quocbao.bookingreser.request.UserRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

	@Column(name = "date_of_birth")
	private Date dateofBirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "image")
	private String image;

	@Column(name = "phone")
	private String phone;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	public User(UserRequest userRequest) {
		this.firstName = userRequest.getFirstName();
		this.lastName = userRequest.getLastName();
		this.dateofBirth = userRequest.getDateofBirth();
		this.gender = userRequest.getGender();
		this.image = userRequest.getImage();
		this.address = new Address(userRequest.getAddressRequest());
		
	}

	public void setUser(UserRequest userRequest) {
		this.firstName = userRequest.getFirstName();
		this.lastName = userRequest.getLastName();
		this.dateofBirth = userRequest.getDateofBirth();
		this.gender = userRequest.getGender();
		this.image = userRequest.getImage();
	}
}
