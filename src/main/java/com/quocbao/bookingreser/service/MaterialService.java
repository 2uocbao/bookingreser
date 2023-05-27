package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.MaterialRequest;
import com.quocbao.bookingreser.response.MaterialResponse;

public interface MaterialService {

	public void createMaterial(MaterialRequest materialRequest);

	public MaterialResponse detailMaterial(Long id);

	public void updateMaterial(Long id, MaterialRequest materialRequest);

	public void uStatusMaterial(Long id, String status);

	public List<MaterialResponse> findByCode(Long companyId, String code);

	public List<MaterialResponse> materials(Long companyId);
}
