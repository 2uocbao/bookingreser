package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Employee;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> phone;
	public static volatile SingularAttribute<Employee, String> email;
	public static volatile SingularAttribute<Employee, Long> companyId;
	public static volatile SingularAttribute<Employee, String> status;
	
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";
	public static final String COMPANYID = "company";
	public static final String STATUS = "status";
}
