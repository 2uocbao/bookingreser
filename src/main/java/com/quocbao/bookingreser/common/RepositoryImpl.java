package com.quocbao.bookingreser.common;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public abstract class RepositoryImpl<E> implements RepositoryDao<E>{

	private Class<E> claz;

	@SuppressWarnings("unchecked")
	public void repositoryImpl() {
		this.claz = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected RepositoryImpl(Class<E> entityClass) {
        this.claz = entityClass;
    }

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return getSession().getCriteriaBuilder();
	}

	public CriteriaQuery<E> createCriteriaQuery() {
		return getCriteriaBuilder().createQuery(claz);
	}

	@SuppressWarnings("deprecation")
	public void save(E obj) {
		getSession().save(obj);// done
	}

	public void update(E obj) {
		this.getSession().merge(obj);
	}

	@SuppressWarnings("deprecation")
	public void delete(E obj) {
		getSession().delete(obj);
	}

	public E findById(Long id) {
		return getSession().get(claz, id); // done
	}

	public E findByColumn(String column, String keySearch) {
		CriteriaQuery<E> builder = createCriteriaQuery();
		Root<E> translation = builder.from(claz);
		builder.select(translation).where(getCriteriaBuilder().equal(translation.get(column), keySearch));
		return getSession().createQuery(builder).uniqueResult();
	}
	
	public List<E> getAll(String column, String value) {
        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = builder.createQuery(claz);
        Root<E> translation = criteriaQuery.from(claz);
        criteriaQuery.from(claz);
        criteriaQuery.where(builder.equal(translation.get(column), value));
        return getSession().createQuery(criteriaQuery).getResultList();
    }

	@SuppressWarnings("deprecation")
	@Override
	public void uColumn(Long id, String nColumn, int value) {
		CriteriaBuilder builder = getCriteriaBuilder();
		CriteriaUpdate<E> update = builder.createCriteriaUpdate(claz);
		Root<E> root = update.from(claz);
		update.set(root.get(nColumn), value);
		update.where(builder.equal(root.get("id"), id));
		getSession().createQuery(update).executeUpdate();
	}
}
