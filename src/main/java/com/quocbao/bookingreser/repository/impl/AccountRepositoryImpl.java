package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Account;
import com.quocbao.bookingreser.repository.AccountRepository;

@Repository
public class AccountRepositoryImpl extends RepositoryImpl<Account> implements AccountRepository {

	protected AccountRepositoryImpl() {
		super(Account.class);
	}

}
