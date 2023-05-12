package com.quocbao.bookingreser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.repository.TypeRepository;
import com.quocbao.bookingreser.request.TypeRequest;
import com.quocbao.bookingreser.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeRepository typeRepository;

	@Override
	public void addType(TypeRequest typeRequest) {
		typeRepository.save(new Types(typeRequest));
	}

}
