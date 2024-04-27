package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Rated;
import com.quocbao.bookingreser.entity.metamodel.Rated_;
import com.quocbao.bookingreser.exception.ResourceNotFoundException;
import com.quocbao.bookingreser.repository.CompanyRepository;
import com.quocbao.bookingreser.repository.RatedRepository;
import com.quocbao.bookingreser.repository.UserRepository;
import com.quocbao.bookingreser.request.RateRequest;
import com.quocbao.bookingreser.response.RateResponse;
import com.quocbao.bookingreser.service.RatedService;

@Service
public class RatedServiceImpl implements RatedService {

	@Autowired
	RatedRepository ratedRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void createRated(RateRequest rateRequest) {
		ratedRepository.save(new Rated(rateRequest, companyRepository.findById(rateRequest.getCompanyId()),
				userRepository.findById(rateRequest.getUserId())));
	}

	@Override
	public RateResponse detailRated(Long id) {
		Rated rated = ratedRepository.findById(id);
		if (rated != null) {
			throw new ResourceNotFoundException("Rated information not found");
		}
		return new RateResponse(rated);
	}

	@Override
	public void updateRated(RateRequest rateRequest) {
//		Rated rated = ratedRepository.findById(id);
//		rated.setRated(rateRequest);
//		ratedRepository.update(rated);
	}

	@Override
	public void deleteRated(Long id) {
		Rated rated = ratedRepository.findById(id);
		ratedRepository.delete(rated);
	}

	@Override
	public List<RateResponse> listRatedByCompanyId(Long companyId) {
		return new RateResponse().rateResponses(ratedRepository.getAll(Company.class, Rated_.COMPANYID, "id", companyId.toString()));
	}
}
