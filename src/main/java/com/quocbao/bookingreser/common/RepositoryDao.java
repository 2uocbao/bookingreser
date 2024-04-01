package com.quocbao.bookingreser.common;

import java.util.List;

public interface RepositoryDao<E> {

	public void repositoryImpl();

	public void save(E obj);

	public void update(E obj);

	public void delete(E obj);

	public E findById(Long id);

	public E findByColumn(String column, String keySearch);

	public <T> List<E> getAll(Class<T> t, String column, String keyJoin, String value);
	
	public void uColumn(Long id, String nColumn, String value);
	
	public List<E> search(String column, String keySearch);
}
