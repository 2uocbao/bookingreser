package com.quocbao.bookingreser.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicUpdate;

import com.quocbao.bookingreser.request.AddressRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "address")
@DynamicUpdate
@NoArgsConstructor
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "aparment_number")
	private String aparmentNumber;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "ward")
	private String ward;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "province")
	private String province;
	
	public Address(AddressRequest addressRequest) {
		this.id = addressRequest.getId();
		this.aparmentNumber = addressRequest.getAparmentNumber();
		this.street = addressRequest.getStreet();
		this.ward = addressRequest.getWard();
		this.district = addressRequest.getDistrict();
		this.province = addressRequest.getProvince();
	}
	
	public Address(String district, String province) {
		this.district = district;
		this.province = province;
	}
}
