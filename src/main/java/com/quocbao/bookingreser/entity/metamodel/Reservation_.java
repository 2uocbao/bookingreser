package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Reservation;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reservation.class)
public abstract class Reservation_ {

	public static volatile SingularAttribute<Reservation, Long> companyId;
	public static volatile SingularAttribute<Reservation, Long> userId;
	
	public static final String COMPANYID = "company";
	public static final String USERID = "user";
}
