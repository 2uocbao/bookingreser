package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.Material;

public interface MaterialRepository {

	public Material createMaterial(Material material);
	
	public Material detailMaterial(Long id);
	
	public Material updateMaterial(Material material);
	
	public List<Material> listMaterialByCompanyId(Long companyId);
}
