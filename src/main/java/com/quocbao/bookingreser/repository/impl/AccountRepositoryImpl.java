package com.quocbao.bookingreser.repository.impl;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Account;
import com.quocbao.bookingreser.repository.AccountRepository;

public class AccountRepositoryImpl extends RepositoryImpl<Account> implements AccountRepository {

	protected AccountRepositoryImpl() {
		super(Account.class);
	}

}
