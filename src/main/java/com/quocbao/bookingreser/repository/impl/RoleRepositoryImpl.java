package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.AccountRole;
import com.quocbao.bookingreser.repository.RoleRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RoleRepositoryImpl extends RepositoryImpl<AccountRole> implements RoleRepository {

	protected RoleRepositoryImpl() {
		super(AccountRole.class);
	}

}
