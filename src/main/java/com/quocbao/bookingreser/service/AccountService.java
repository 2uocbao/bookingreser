package com.quocbao.bookingreser.service;

import com.quocbao.bookingreser.request.AccountRequest;

public interface AccountService {

	public void createAccount(AccountRequest accountRequest);

	public void updateAccountRole(AccountRequest accountRequest);
}
