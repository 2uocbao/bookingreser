package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Services;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Services.class)
public class Services_ {

	public static volatile SingularAttribute<Services, Long> id;
	public static volatile SingularAttribute<Services, Long> companyId;
	public static volatile SingularAttribute<Services, String> status;

	public static final String ID = "id";
	public static final String COMPANYID = "company";
	public static final String STATUS = "status";
}
