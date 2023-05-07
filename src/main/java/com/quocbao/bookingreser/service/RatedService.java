package com.quocbao.bookingreser.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quocbao.bookingreser.request.RateRequest;
import com.quocbao.bookingreser.response.RateResponse;

public interface RatedService {

	public ResponseEntity<RateResponse> createRated(RateRequest rateRequest);

	public ResponseEntity<RateResponse> detailRated(Long id);

	public ResponseEntity<RateResponse> updateRated(RateRequest rateRequest);

	public void deleteRated(Long id);

	public ResponseEntity<List<RateResponse>> listRatedByCompanyId(Long companyId);
}
