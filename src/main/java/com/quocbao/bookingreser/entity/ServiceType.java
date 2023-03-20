package com.quocbao.bookingreser.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "service_type")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ServiceType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TypeRatingKey id;
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "service_id")
	private Long serviceId;
	
	@ManyToOne
	@MapsId("type_id")
	@JoinColumn(name = "type_id")
	private Long typeId;
}
