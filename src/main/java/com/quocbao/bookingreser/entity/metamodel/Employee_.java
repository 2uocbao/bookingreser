package com.quocbao.bookingreser.entity.metamodel;

import java.sql.Timestamp;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, String> lastName;
	public static volatile SingularAttribute<Employee, String> firstName;
	public static volatile SingularAttribute<Employee, String> image;
	public static volatile SingularAttribute<Employee, String> phone;
	public static volatile SingularAttribute<Employee, String> email;
	public static volatile SingularAttribute<Employee, Company> company;
	public static volatile SingularAttribute<Employee, String> status;
	public static volatile SingularAttribute<Employee, Integer> kpa;
	public static volatile SingularAttribute<Employee, Timestamp> createdAt;
	public static volatile SingularAttribute<Employee, Timestamp> updatedAt;

	public static final String ID = "id";
	public static final String LASTNAME = "lastName";
	public static final String FIRSTNAME = "firstName";
	public static final String IMAGE = "image";
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";
	public static final String COMPANY = "company";
	public static final String STATUS = "status";
	public static final String KPA = "kpa";
	public static final String CREATEDAT = "createdAt";
	public static final String UPDATEDAT = "updated_at";
}
