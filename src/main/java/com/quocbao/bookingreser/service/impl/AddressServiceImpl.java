package com.quocbao.bookingreser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Address;
import com.quocbao.bookingreser.repository.AddressRepository;
import com.quocbao.bookingreser.request.AddressRequest;
import com.quocbao.bookingreser.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public void createAddress(AddressRequest addressRequest) {
		Address address = new Address(addressRequest);
		addressRepository.save(address);
	}

	@Override
	public void updateAddress(Long id, AddressRequest addressRequest) {
		Address address = addressRepository.findById(id);
		address.address(addressRequest);
		addressRepository.update(address);
	}
}
