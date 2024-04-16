package com.quocbao.bookingreser.entity.metamodel;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Material;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Material.class)
public abstract class Material_ {

	public static volatile SingularAttribute<Material, Long> id;
	public static volatile SingularAttribute<Material, Company> company;
	public static volatile SingularAttribute<Material, String> name;
	public static volatile SingularAttribute<Material, String> status;
	public static volatile SingularAttribute<Material, String> code;

	public static final String ID = "id";
	public static final String COMPANY = "company";
	public static final String NAME = "name";
	public static final String STATUS = "status";
	public static final String CODE = "code";
}
