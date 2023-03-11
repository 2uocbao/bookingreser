package com.quocbao.bookingreser.repository;

import com.quocbao.bookingreser.entity.Account;

public interface AccountRepository {
	
	public Account createAccount(Account account);
	
	public Account updateAccount(Account account);
}
