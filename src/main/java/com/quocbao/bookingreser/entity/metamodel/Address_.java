package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Address;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, String> aparmentNumber;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, String> ward;
	public static volatile SingularAttribute<Address, String> district;
	public static volatile SingularAttribute<Address, String> province;
	
	public static final String APARMENTNUMBER = "aparment_number";
	public static final String STREET = "street";
	public static final String WARD = "ward";
	public static final String DISTRICT = "district";
	public static final String PROVINCE = "province";
}
