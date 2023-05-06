package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.repository.MaterialRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MaterialRepositoryImpl extends RepositoryImpl<Material> implements MaterialRepository {

	protected MaterialRepositoryImpl() {
		super(Material.class);
	}

}
