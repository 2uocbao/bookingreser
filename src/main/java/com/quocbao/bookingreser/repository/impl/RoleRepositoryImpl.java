package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Role;
import com.quocbao.bookingreser.repository.RoleRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RoleRepositoryImpl extends RepositoryImpl<Role> implements RoleRepository {

	protected RoleRepositoryImpl() {
		super(Role.class);
	}

}
