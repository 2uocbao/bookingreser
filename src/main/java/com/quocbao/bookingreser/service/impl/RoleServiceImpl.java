package com.quocbao.bookingreser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Role;
import com.quocbao.bookingreser.repository.RoleRepository;
import com.quocbao.bookingreser.request.RoleRequest;
import com.quocbao.bookingreser.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void createRole(RoleRequest roleRequest) {
		roleRepository.save(new Role(roleRequest));
	}

}
