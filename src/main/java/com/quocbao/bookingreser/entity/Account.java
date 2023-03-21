package com.quocbao.bookingreser.entity;

import java.io.Serializable;

import com.quocbao.bookingreser.request.AccountRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	public Account(AccountRequest accountRequest) {
		this.username = accountRequest.getUsername();
		this.password = accountRequest.getPassword();
	}
}
