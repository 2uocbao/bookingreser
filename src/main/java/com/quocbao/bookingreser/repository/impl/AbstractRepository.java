package com.quocbao.bookingreser.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.criteria.CriteriaBuilder;

public abstract class AbstractRepository<P extends Serializable>{

	private final Class<P> persistentClass;
	
	@SuppressWarnings("unchecked")
	protected AbstractRepository(){
		this.persistentClass =(Class<P>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("deprecation")
	public P create(P entity) {
		getSession().save(entity);
		return entity;
	}
	
	@SuppressWarnings("deprecation")
	public P update(P entity) {
		getSession().update(entity);
		return entity;
	}
	
	public P detail(Long id) {
		return getSession().get(persistentClass, id);
	}
	
	protected CriteriaBuilder getBuilder() {
		return this.getSession().getCriteriaBuilder();
	}
}
