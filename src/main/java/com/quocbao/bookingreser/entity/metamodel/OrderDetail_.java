package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.OrderDetail;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderDetail.class)
public abstract class OrderDetail_ {

	public static volatile SingularAttribute<OrderDetail, Long> orderId;
	public static volatile SingularAttribute<OrderDetail, String> status;
	
	public static final String ORDERID = "order";
	public static final String STATUS = "status";
}
