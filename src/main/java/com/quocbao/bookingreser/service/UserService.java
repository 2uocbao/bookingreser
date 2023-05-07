package com.quocbao.bookingreser.service;

import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.request.EmpUserRequest;

public interface UserService {

	public void createUser(EmpUserRequest empUserRequest);

	public User updateUser(Long id, EmpUserRequest empUserRequest);

	public void detailUser(Long id);

	public void deleteUser(Long id);
}
