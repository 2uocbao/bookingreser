package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import com.quocbao.bookingreser.entity.Service;
import com.quocbao.bookingreser.repository.ServiceRepository;

public class ServiceRepositoryImpl extends AbstractRepository<Service> implements ServiceRepository {

	@Override
	public Service createService(Service service) {
		return this.create(service);
	}

	@Override
	public Service detailServiec(Long id) {
		return this.detail(id);
	}

	@Override
	public Service updateService(Service service) {
		return this.update(service);
	}

	@Override
	public List<Service> listServiceByColumn(String columnName, String keySearch) {
		return this.listEnityByColumn(columnName, keySearch);
	}

	@Override
	public List<Service> listServiceByCompanyId(Long companyId) {
		return this.listServiceByCompanyId(companyId);
	}

}
