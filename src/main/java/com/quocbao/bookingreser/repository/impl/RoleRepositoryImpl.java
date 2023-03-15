package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.AccountRole;
import com.quocbao.bookingreser.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl extends AbstractRepository<AccountRole> implements RoleRepository {

	@Override
	public AccountRole createAccountRole(AccountRole accountRole) {
		return this.create(accountRole);
	}

	@Override
	public AccountRole updateAccountRole(AccountRole accountRole) {
		return this.update(accountRole);
	}
}
