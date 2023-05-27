package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Company;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Company.class)
public abstract class Company_ {

	public static volatile SingularAttribute<Company, String> phone;
	public static volatile SingularAttribute<Company, String> email;
	public static volatile SingularAttribute<Company, Integer> status;

	public static final String PHONE = "phone";
	public static final String EMAIL = "email";
	public static final String STATUS = "status";

}
