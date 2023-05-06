package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Material;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Material.class)
public abstract class Material_ {

	public static volatile SingularAttribute<Material, Long> companyId;
	public static volatile SingularAttribute<Material, String> status;
	public static volatile SingularAttribute<Material, String> code;

	public static final String COMPANYID = "company";
	public static final String STATUS = "status";
	public static final String CODE = "code";
}
