package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.Rated;

public interface RatedRepository {

	public Rated createRated(Rated rated);
	
	public Rated detailRated(Long id);
	
	public Rated updateRated(Rated rated);
	
	public void deleteRated(Rated rated);
	
	public List<Rated> listRatedByCompanyId(Long companyId);
}
