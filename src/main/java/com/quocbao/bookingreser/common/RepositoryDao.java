package com.quocbao.bookingreser.common;

import java.util.List;

public interface RepositoryDao<E> {

	public void repositoryImpl();

	public void save(E obj);

	public void update(E obj);

	public void delete(E obj);

	public E findById(Long id);

	public E findByColumn(String column, String keySearch);
	
	public List<E> getList();
}
