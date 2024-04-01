package com.quocbao.bookingreser.service;

import com.quocbao.bookingreser.request.AddressRequest;

public interface AddressService {
	
	public void createAddress(AddressRequest addressRequest);
		
	public void updateAddress(Long id, AddressRequest addressRequest);
	 
}
