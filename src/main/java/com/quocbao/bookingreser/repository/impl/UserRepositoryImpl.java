package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.repository.UserRepository;

@Repository
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

	@Override
	public User createUser(User user) {
		return this.create(user);
	}

	@Override
	public User updateUser(User user) {
		return this.update(user);
	}

	@Override
	public User detailUser(Long id) {
		return this.detail(id);
	}

	@Override
	public void deleteUser(User user) {
		this.delete(user);
	}

}
