package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.ServiceRequest;
import com.quocbao.bookingreser.response.ServiceResponse;

public interface ServicesService {

	public void createService(ServiceRequest serviceRequest);

	public ServiceResponse detailService(Long id);
	
	public List<ServiceResponse> listServiceByCompany(Long companyId);
}
