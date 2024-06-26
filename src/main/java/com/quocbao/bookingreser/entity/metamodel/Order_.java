package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Order;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcesser")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SingularAttribute<Order, Long> companyId;
	public static volatile SingularAttribute<Order, Long> serviceId;
	public static volatile SingularAttribute<Order, Long> employeeId;
	public static volatile SingularAttribute<Order, Long> userId;
	public static volatile SingularAttribute<Order, String> status;

	public static final String ID = "id";
	public static final String SERVICEID = "service";
	public static final String COMPANYID = "company";
	public static final String EMPLOYEEID = "employee";
	public static final String USERID = "user";
	public static final String STATUS = "status";

}
