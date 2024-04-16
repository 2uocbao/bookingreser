package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.metamodel.Material_;
import com.quocbao.bookingreser.exception.ResourceNotFoundException;
import com.quocbao.bookingreser.exception.ValidationException;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.request.MaterialRequest;
import com.quocbao.bookingreser.response.MaterialResponse;
import com.quocbao.bookingreser.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialRepository materialRepository;

	@Override
	public void createMaterial(MaterialRequest materialRequest) {
		validMaterial((long) 0, materialRequest.getCompanyId() , materialRequest.getCode());
		Material material = new Material(materialRequest);
		Company company = new Company();
		company.setId(materialRequest.getCompanyId());
		material.setCompany(company);
		materialRepository.save(material);
	}

	@Override
	public MaterialResponse detailMaterial(Long id) {
		Material material = materialRepository.findById(id);
		if (material == null) {
			throw new ResourceNotFoundException("with id: " + id);
		}
		return new MaterialResponse(material);
	}

	@Override
	public void updateMaterial(MaterialRequest materialRequest) {
		Material material = new Material(materialRequest);
		Company company = new Company();
		company.setId(materialRequest.getCompanyId());
		material.setCompany(company);
		try {
			materialRepository.update(material);
		} catch (Exception e) {
			throw new ValidationException("Ojbect does not exist");
		}
	}

	@Override
	public void uStatusMaterial(Long id, String status) {
		materialRepository.uColumn(id, Material_.STATUS, status);
	}

	@Override
	public List<MaterialResponse> materials(Long companyId) {
		return new MaterialResponse()
				.materialResponses(materialRepository.materials(companyId));
	}
	
	public void validMaterial(Long id, Long companyId, String code) {
		Long retrieveId = materialRepository.checkValueExist(companyId, code);
		if(id == 0 && retrieveId > 0) {
			throw new ValidationException(code);
		} 
		else if(id > 0 && retrieveId != id) {
			throw new ValidationException(code);
		}
	}
}
