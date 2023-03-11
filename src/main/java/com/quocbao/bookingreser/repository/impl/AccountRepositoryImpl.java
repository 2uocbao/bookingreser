package com.quocbao.bookingreser.repository.impl;

import com.quocbao.bookingreser.entity.Account;
import com.quocbao.bookingreser.repository.AccountRepository;

public class AccountRepositoryImpl extends AbstractRepository<Account> implements AccountRepository {

	@Override
	public Account createAccount(Account account) {
		return this.create(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return this.update(account);
	}

}
