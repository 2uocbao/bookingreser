package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Address;
import com.quocbao.bookingreser.repository.AddressRepository;

@Repository
public class AddressRepositoryImpl extends RepositoryImpl<Address> implements AddressRepository {

	protected AddressRepositoryImpl() {
		super(Address.class);
	}

}
