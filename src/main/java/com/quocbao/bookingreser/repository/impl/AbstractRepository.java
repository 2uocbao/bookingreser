package com.quocbao.bookingreser.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRepository<PK extends Serializable, T>{

	@SuppressWarnings("unused")
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	protected AbstractRepository(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
}
