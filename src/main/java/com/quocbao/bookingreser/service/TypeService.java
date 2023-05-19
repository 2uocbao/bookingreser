package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.TypeRequest;
import com.quocbao.bookingreser.response.TypeResponse;

public interface TypeService {

	public void addType(TypeRequest typeRequest);

	public List<TypeResponse> types(String type);
}
