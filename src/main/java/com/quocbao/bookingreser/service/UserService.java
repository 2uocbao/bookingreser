package com.quocbao.bookingreser.service;

import com.quocbao.bookingreser.entity.User;

public interface UserService {

public User createUser(User user);
	
	public User updateUser(User user);
	
	public User detailUser(Long id);
	
	public void deleteUser(User user);
}
