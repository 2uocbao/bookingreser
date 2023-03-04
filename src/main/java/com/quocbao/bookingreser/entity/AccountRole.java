package com.quocbao.bookingreser.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "account_role")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TypeRatingKey id;
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "account_id")
	private Long accountId;
	
	@ManyToOne
	@MapsId("type_id")
	@JoinColumn(name = "role_id")
	private Long roleId;
	
	@Column(name = "status")
	private int status;
}
