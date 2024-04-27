package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Rated;
import com.quocbao.bookingreser.repository.RatedRepository;

@Repository
public class RatedRepositoryImpl extends RepositoryImpl<Rated> implements RatedRepository {

	protected RatedRepositoryImpl() {
		super(Rated.class);
	}

}
