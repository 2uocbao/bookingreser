package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.common.RepositoryDao;
import com.quocbao.bookingreser.entity.Material;

public interface MaterialRepository extends RepositoryDao<Material> {
	
	public List<Material> materials(Long companyId);
	
	public Long checkValueExist(Long companyId, String code);
}
