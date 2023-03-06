package com.quocbao.bookingreser.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.criteria.CriteriaBuilder;

public abstract class AbstractRepository<P extends Serializable, T>{

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
	
	@SuppressWarnings("deprecation")
	public T create(T entity) {
		getSession().save(entity);
		return entity;
	}
	
	@SuppressWarnings("deprecation")
	public T update(T entity) {
		getSession().update(entity);
		return entity;
	}
	
	public T detail(P id) {
		return getSession().get(persistentClass, id);
	}
	
	protected CriteriaBuilder getBuilder() {
		return this.getSession().getCriteriaBuilder();
	}
}
