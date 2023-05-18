package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.quocbao.bookingreser.request.AccountRequest;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "account")
@DynamicUpdate
@NoArgsConstructor
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToMany
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public Account(AccountRequest accountRequest) {
		this.username = accountRequest.getUsername();
		this.password = accountRequest.getPassword();
	}
}
