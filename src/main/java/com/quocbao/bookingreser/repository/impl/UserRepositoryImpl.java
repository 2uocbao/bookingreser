package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.repository.UserRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl extends RepositoryImpl<User> implements UserRepository {

	protected UserRepositoryImpl() {
		super(User.class);
	}

}
