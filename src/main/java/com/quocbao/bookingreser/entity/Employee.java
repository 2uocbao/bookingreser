package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import com.quocbao.bookingreser.request.EmpUserRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column(name = "password")
	private String password;

	@Column(name = "kpa")
	private int kpa;

	@Column(name = "status")
	private int status;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	//relationship
	
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	@OneToMany(mappedBy = "employee")
	private Set<WarehouseDetail> warehouseDetails;
	
	public Employee(EmpUserRequest employeeRequest, Company company) {
		this.company = company;
		this.firstName = employeeRequest.getFirstName();
		this.lastName = employeeRequest.getLastName();
		this.dateofBirth = employeeRequest.getDateofBirth();
		this.gender = employeeRequest.getGender();
		this.image = employeeRequest.getImage();
		this.phone = employeeRequest.getPhone();
		this.email = employeeRequest.getEmail();
		this.address = employeeRequest.getAddress();
	}
}
