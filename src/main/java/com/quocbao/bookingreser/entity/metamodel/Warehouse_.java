package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Warehouse;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Warehouse.class)
public abstract class Warehouse_ {

	public static volatile SingularAttribute<Warehouse, Long> materialId;
	public static volatile SingularAttribute<Warehouse, String> status;

	public static final String MATERIALID = "material";
	public static final String STATUS = "status";
}
