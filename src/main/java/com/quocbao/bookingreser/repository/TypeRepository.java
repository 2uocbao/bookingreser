package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.common.RepositoryDao;
import com.quocbao.bookingreser.entity.Types;

public interface TypeRepository extends RepositoryDao<Types> {

	public List<Types> types(String type);
}
