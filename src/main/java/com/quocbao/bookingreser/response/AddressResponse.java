package com.quocbao.bookingreser.response;

import com.quocbao.bookingreser.entity.Address;
import com.quocbao.bookingreser.request.AddressRequest;

import lombok.Setter;

@Setter
public class AddressResponse extends AddressRequest{

	public AddressResponse(Address address) {
		this.aparmentNumber = address.getAparmentNumber();
		this.road = address.getRoad();
		this.ward = address.getWard();
		this.district = address.getDistrict();
		this.province = address.getProvince();
	}
	
}
