package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.repository.FoodRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FoodRepositoryImpl extends RepositoryImpl<Food> implements FoodRepository {

	protected FoodRepositoryImpl() {
		super(Food.class);
	}

}
