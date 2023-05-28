package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Services;
import com.quocbao.bookingreser.repository.ServicesRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ServicesRepositoryImpl extends RepositoryImpl<Services> implements ServicesRepository {

	protected ServicesRepositoryImpl() {
		super(Services.class);
	}

}
