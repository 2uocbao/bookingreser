package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.metamodel.Material_;
import com.quocbao.bookingreser.exception.AlreadyExistException;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.request.MaterialRequest;
import com.quocbao.bookingreser.response.MaterialResponse;
import com.quocbao.bookingreser.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialRepository materialRepository;
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public void createMaterial(MaterialRequest materialRequest) {
		if (findByCode(materialRequest.getCompanyId(), materialRequest.getCode()) != null) {
			throw new AlreadyExistException("Material already exist with code: " + materialRequest.getCode());
		}
		materialRepository
				.save(new Material(materialRequest, companyRepository.findById(materialRequest.getCompanyId())));
	}

	@Override
	public MaterialResponse detailMaterial(Long id) {
		Material material = materialRepository.findById(id);
		if (material == null) {
			throw new NotFoundException("Material not found with id: " + id.toString());
		}
		return new MaterialResponse(material);
	}

	@Override
	public void updateMaterial(Long id, MaterialRequest materialRequest) {
		Material material = materialRepository.findById(id);
		material.setMaterial(materialRequest);
		materialRepository.update(material);
	}

	@Override
	public void uStatusMaterial(Long id, String status) {
		materialRepository.uColumn(id, Material_.STATUS, status);
	}

	@Override
	public List<MaterialResponse> findByCode(Long companyId, String code) {
		return new MaterialResponse()
				.materialResponses(materialRepository.getAll(Company.class, Material_.CODE, "id", companyId).stream()
						.filter(x -> x.getCode().contains(code)).toList());
	}

	@Override
	public List<MaterialResponse> materials(Long companyId) {
		return new MaterialResponse()
				.materialResponses(materialRepository.getAll(Company.class, Material_.COMPANYID, "id", companyId));
	}
}
