package com.quocbao.bookingreser.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public abstract class AbstractRepository<P extends Serializable>{

	@Autowired
	protected EntityManager entityManager;
	
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
	
	public P create(P entity) {
		getSession().persist(entity);
		return entity;
	}
	
	public P update(P entity) {
		getSession().merge(entity);
		return entity;
	}
	
	public P detail(Long id) {
		return getSession().get(persistentClass, id);
	}
	
	public void delete(P entity) {
		getSession().remove(entity);
	}
	
	protected CriteriaBuilder getBuilder() {
		return this.getSession().getCriteriaBuilder();
	}
	
	public List<P> listEnityByColumn(String nameColumn, String search){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<P> criteria = builder.createQuery(persistentClass);
		Root<P> translation = criteria.from(persistentClass);
		criteria.select(translation);
		criteria.where(builder.equal(translation.get(nameColumn), search));
		TypedQuery<P> query = entityManager.createQuery(criteria);
		return query.getResultList();
	}
}
