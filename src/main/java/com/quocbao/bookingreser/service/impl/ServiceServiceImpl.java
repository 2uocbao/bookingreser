package com.quocbao.bookingreser.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Services;
import com.quocbao.bookingreser.entity.Types;
import com.quocbao.bookingreser.entity.metamodel.Services_;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.ServicesRepository;
import com.quocbao.bookingreser.repository.TypeRepository;
import com.quocbao.bookingreser.request.ServiceRequest;
import com.quocbao.bookingreser.response.ServiceResponse;
import com.quocbao.bookingreser.service.ServicesService;

@Service
public class ServiceServiceImpl implements ServicesService {

	@Autowired
	private ServicesRepository serviceRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private TypeRepository typeRepository;

	@Override
	public void createService(ServiceRequest serviceRequest) {
		Services services = new Services(serviceRequest, companyRepository.findById(serviceRequest.getCompanyId()));
		Set<Types> types = new HashSet<>();
		serviceRequest.getType().stream().forEach(x -> types.add(typeRepository.findById(x)));
		services.setTypes(types);
		serviceRepository.save(services);
	}

	@Override
	public ServiceResponse detailService(Long id) {
		return new ServiceResponse(serviceRepository.findById(id));
	}

	@Override
	public List<ServiceResponse> listServiceByCompany(Long companyId) {
		return new ServiceResponse()
				.serviceResponses(serviceRepository.getAll(Company.class, Services_.COMPANYID, "id", companyId));
	}
}
