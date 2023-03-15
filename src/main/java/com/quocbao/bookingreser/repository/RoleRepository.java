package com.quocbao.bookingreser.repository;

import com.quocbao.bookingreser.entity.AccountRole;

public interface RoleRepository {

	public AccountRole createAccountRole(AccountRole accountRole);
	
	public AccountRole updateAccountRole(AccountRole accountRole);
}
