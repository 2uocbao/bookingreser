package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.request.MaterialRequest;

public interface MaterialService {

	public void createMaterial(MaterialRequest materialRequest);
	
	public Material detailMaterial(Long id);
	
	public void updateMaterial(Long id, MaterialRequest materialRequest);
	
	public void uStatusMaterial(Long id, int value);
	
	public List<Material> findByCode(Long companyId, String code);
	
	public List<Material> materials(Long companyId);
}
