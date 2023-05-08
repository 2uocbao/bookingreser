package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Rated;
import com.quocbao.bookingreser.request.RateRequest;

public interface RatedService {

	public void createRated(RateRequest rateRequest);

	public Rated detailRated(Long id);

	public void updateRated(Long id, RateRequest rateRequest);

	public void deleteRated(Long id);

	public List<Rated> listRatedByCompanyId(Long companyId);
}
