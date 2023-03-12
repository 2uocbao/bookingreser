package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.Service;

public interface ServiceRepository {

	public Service createService(Service service);
	
	public Service detailServiec(Long id);
	
	public Service updateService(Service service);
	
	public List<Service> listServiceByColumn(String columnName, String keySearch);
	
	public List<Service> listServiceByCompanyId(Long companyId);
}
