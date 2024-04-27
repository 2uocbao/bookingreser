package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.quocbao.bookingreser.request.EmployeeRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "firstName")
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

	@Column(name = "kpa")
	private int kpa;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt")
	private Timestamp createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// relationship

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;
	
	@OneToMany(mappedBy = "employee")
	private List<Order> order; 

	@OneToMany(mappedBy = "employee")
	private Set<Warehouse> warehouse;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	public Employee(EmployeeRequest employeeRequest) {
		this.id = employeeRequest.getId();
		this.firstName = employeeRequest.getFirstName();
		this.lastName = employeeRequest.getLastName();
		this.dateofBirth = employeeRequest.getDateofBirth();
		this.gender = employeeRequest.getGender();
		this.image = employeeRequest.getImage();
		this.email = employeeRequest.getEmail();
		this.phone = employeeRequest.getPhone();
		this.address = new Address(employeeRequest.getAddressRequest());
		this.kpa = employeeRequest.getKpa();
		this.createdAt = employeeRequest.getCreatedAt();
	}
	
	public Employee(Long id, String firstName, String lastName, String image, int kpa, Timestamp createdAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
		this.kpa = kpa;
		this.createdAt = createdAt;
	}
}
