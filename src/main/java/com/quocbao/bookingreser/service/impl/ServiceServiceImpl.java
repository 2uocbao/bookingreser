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
import com.quocbao.bookingreser.exception.ValidationException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.ServicesRepository;
import com.quocbao.bookingreser.repository.TypeRepository;
import com.quocbao.bookingreser.request.ServiceRequest;
import com.quocbao.bookingreser.response.ServiceResponse;
import com.quocbao.bookingreser.service.ServicesService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceServiceImpl implements ServicesService {

	@Autowired
	private ServicesRepository serviceRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private TypeRepository typeRepository;

	@Override
	public void createService(ServiceRequest serviceRequest) {
		Services service = new Services(serviceRequest, companyRepository.findById(serviceRequest.getCompanyId()));
		List<Services> services = serviceRepository.getAll(Company.class, Services_.COMPANYID, "id", serviceRequest.getCompanyId().toString());
		for(Services servic : services) {
			if(servic.getName().toLowerCase().equals(serviceRequest.getName().toLowerCase())) {
				throw new ValidationException("This name is already exits");
			}
		}
		serviceRepository.save(service);
	}

	@Override
	public ServiceResponse detailService(Long id) {
		Services services = serviceRepository.findById(id);
		return serviceResponse(services);
	}

	@Override
	public List<ServiceResponse> listServiceByCompany(Long companyId) {
		List<Services> services = serviceRepository.getAll(Company.class, Services_.COMPANYID, "id", companyId.toString());
		return services.stream().map(this::serviceResponse).toList();
	}

	public Set<Types> types(List<String> typeIds) {
		Set<Types> types = new HashSet<>();
		typeIds.stream().forEach(x -> types.add(typeRepository.findById(Long.parseLong(x))));
		return types;
	}

	public ServiceResponse serviceResponse(Services services) {
		ServiceResponse serviceResponse = new ServiceResponse(services);
		return serviceResponse;
	}
}
