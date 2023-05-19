package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.repository.TypeRepository;
import com.quocbao.bookingreser.request.TypeRequest;
import com.quocbao.bookingreser.response.TypeResponse;
import com.quocbao.bookingreser.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeRepository typeRepository;

	@Override
	public void addType(TypeRequest typeRequest) {
		typeRepository.save(new Types(typeRequest));
	}

	@Override
	public List<TypeResponse> types(String type) {
		return new TypeResponse().typeResponses(typeRepository.types(type));
	}
}
