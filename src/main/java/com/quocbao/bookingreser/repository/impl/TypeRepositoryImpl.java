package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.repository.TypeRepository;

@Repository
public class TypeRepositoryImpl extends RepositoryImpl<Types> implements TypeRepository {

	protected TypeRepositoryImpl() {
		super(Types.class);
	}

}
