package com.quocbao.bookingreser.repository;

import com.quocbao.bookingreser.entity.User;

public interface UserRepository {
	
	public User createUser(User user);
	
	public User updateUser(User user);
	
	public User detailUser(Long id);
	
	public void deleteUser(User user);
}
