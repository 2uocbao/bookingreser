package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Address;
import com.quocbao.bookingreser.entity.Company;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Company.class)
public abstract class Company_ {

	public static volatile SingularAttribute<Company, Long> id;
	public static volatile SingularAttribute<Company, String> name;
	public static volatile SingularAttribute<Company, String> infor;
	public static volatile SingularAttribute<Company, String> image;
	public static volatile SingularAttribute<Company, String> phone;
	public static volatile SingularAttribute<Company, String> email;
	public static volatile SingularAttribute<Company, String> status;
	public static volatile SingularAttribute<Company, Address> address;

	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String INFOR = "infor";
	public static final String IMAGE = "image";
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";
	public static final String STATUS = "status";
	public static final String ADDRESS = "address";

}
