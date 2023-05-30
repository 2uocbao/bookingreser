package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.quocbao.bookingreser.request.EmployeeRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employee")
@DynamicUpdate
@NoArgsConstructor
public class Employee implements Serializable {

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

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "kpa")
	private int kpa;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Timestamp createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// relationship

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	@OneToMany(mappedBy = "employee")
	private Set<Warehouse> warehouse;

	public Employee(EmployeeRequest employeeRequest, Company company) {
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

	public void setEmployee(EmployeeRequest employeeRequest) {
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
