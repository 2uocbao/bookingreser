package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.repository.FoodDetailRepository;

@Repository
public class FoodDetailRepositoryImpl extends RepositoryImpl<FoodDetail> implements FoodDetailRepository {

	protected FoodDetailRepositoryImpl() {
		super(FoodDetail.class);
	}

}
