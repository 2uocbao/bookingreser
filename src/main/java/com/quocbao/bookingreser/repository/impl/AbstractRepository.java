package com.quocbao.bookingreser.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractRepository<PK extends Serializable, T>{

	@SuppressWarnings("unused")
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractRepository(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	
}
