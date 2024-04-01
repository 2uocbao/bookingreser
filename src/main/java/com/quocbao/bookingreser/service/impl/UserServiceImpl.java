package com.quocbao.bookingreser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Address;
import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.entity.metamodel.User_;
import com.quocbao.bookingreser.exception.BookingreserException;
import com.quocbao.bookingreser.repository.AddressRepository;
import com.quocbao.bookingreser.repository.UserRepository;
import com.quocbao.bookingreser.request.UserRequest;
import com.quocbao.bookingreser.security.jwt.JwtTokenProvider;
import com.quocbao.bookingreser.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Override
	public void createUser(UserRequest empUserRequest, String token) {
		User user = new User(empUserRequest);
		user.setPhone(jwtTokenProvider.extractUsername(token));
		Address address = new Address(empUserRequest.getAddressRequest());
		addressRepository.save(address);
		user.setAddress(address);
		userRepository.save(user);
	}

	@Override
	public void updateUser(Long id, UserRequest empUserRequest) {
		User user = userRepository.findById(id);
		user.setUser(empUserRequest);
		Address address = addressRepository.findById(user.getAddress().getId());
		address.address(empUserRequest.getAddressRequest());
		userRepository.update(user);
		addressRepository.update(address);
	}

	@Override
	public User detailUser(String token) {
		String phone = jwtTokenProvider.extractUsername(token);
		User user = userRepository.findByColumn(User_.PHONE, phone);
		if (user == null) {
			throw new BookingreserException(HttpStatus.NOT_FOUND, "User not found");
		}
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(userRepository.findById(id));
	}

}
