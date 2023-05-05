package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Food;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Food.class)
public abstract class Food_ {

	public static volatile SingularAttribute<Food, Long> companyId;
	public static volatile SingularAttribute<Food, Integer> status;

	public static final String COMPANYID = "company";
	public static final String STATUS = "status";
}
