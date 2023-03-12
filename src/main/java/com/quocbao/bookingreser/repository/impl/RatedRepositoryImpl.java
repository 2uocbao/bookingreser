package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.Rated;
import com.quocbao.bookingreser.repository.RatedRepository;

@Repository
public class RatedRepositoryImpl extends AbstractRepository<Rated> implements RatedRepository {

	@Override
	public Rated createRated(Rated rated) {
		return this.create(rated);
	}

	@Override
	public Rated detailRated(Long id) {
		return this.detail(id);
	}

	@Override
	public Rated updateRated(Rated rated) {
		return this.update(rated);
	}

	@Override
	public void deleteRated(Rated rated) {
		this.delete(rated);
	}

	@Override
	public List<Rated> listRatedByCompanyId(Long companyId) {
		return this.listRatedByCompanyId(companyId);
	}

}
