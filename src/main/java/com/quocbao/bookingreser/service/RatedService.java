package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.RateRequest;
import com.quocbao.bookingreser.response.RateResponse;

public interface RatedService {

	public void createRated(RateRequest rateRequest);

	public RateResponse detailRated(Long id);

	public void updateRated(RateRequest rateRequest);

	public void deleteRated(Long id);

	public List<RateResponse> listRatedByCompanyId(Long companyId);
}
