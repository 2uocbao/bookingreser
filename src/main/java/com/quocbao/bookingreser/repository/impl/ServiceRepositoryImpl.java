package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Service;
import com.quocbao.bookingreser.repository.ServiceRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ServiceRepositoryImpl extends RepositoryImpl<Service> implements ServiceRepository {

	protected ServiceRepositoryImpl() {
		super(Service.class);
	}

}
