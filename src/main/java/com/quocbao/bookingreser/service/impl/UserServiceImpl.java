package com.quocbao.bookingreser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.UserRepository;
import com.quocbao.bookingreser.request.UserRequest;
import com.quocbao.bookingreser.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void createUser(UserRequest empUserRequest) {
		userRepository.save(new User(empUserRequest));
	}

	@Override
	public void updateUser(Long id, UserRequest empUserRequest) {
		User user = userRepository.findById(id);
		user.setUser(empUserRequest);
		userRepository.update(user);
	}

	@Override
	public User detailUser(Long id) {
		User user = userRepository.findById(id);
		if (user != null) {
			throw new NotFoundException("User not found with: " + id.toString());
		}
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(userRepository.findById(id));
	}

}
