package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.repository.MaterialRepository;

@Repository
public class MaterialRepositoryImpl extends AbstractRepository<Material> implements MaterialRepository {

	@Override
	public Material createMaterial(Material material) {
		return this.create(material);
	}

	@Override
	public Material detailMaterial(Long id) {
		return this.detail(id);
	}

	@Override
	public Material updateMaterial(Material material) {
		return this.update(material);
	}

	@Override
	public List<Material> listMaterialByCompanyId(Long companyId) {
		return this.listMaterialByCompanyId(companyId);
	}

}
