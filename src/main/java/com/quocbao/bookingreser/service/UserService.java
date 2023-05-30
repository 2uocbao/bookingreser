package com.quocbao.bookingreser.service;

import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.request.UserRequest;

public interface UserService {

	public void createUser(UserRequest empUserRequest);

	public void updateUser(Long id, UserRequest empUserRequest);

	public User detailUser(Long id);

	public void deleteUser(Long id);
}
