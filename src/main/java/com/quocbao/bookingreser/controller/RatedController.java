package com.quocbao.bookingreser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.RateRequest;
import com.quocbao.bookingreser.response.RateResponse;
import com.quocbao.bookingreser.service.RatedService;

@RestController
@RequestMapping("/rated")
public class RatedController {

	@Autowired
	RatedService ratedService;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createRated(@RequestBody RateRequest rateRequest) {
		ratedService.createRated(rateRequest);
	}

	@GetMapping("/{id}/detail")
	@ResponseStatus(code = HttpStatus.OK)
	public RateResponse detailRated(@PathVariable Long id) {
		return ratedService.detailRated(id);
	}

	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateRated(@RequestBody RateRequest rateRequest) {
		ratedService.updateRated(rateRequest);
	}

	@DeleteMapping("/{id}/remove")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeRated(@PathVariable Long id) {
		ratedService.deleteRated(id);
	}

	@GetMapping("/{companyId}/company")
	@ResponseStatus(code = HttpStatus.OK)
	public List<RateResponse> listByCompany(@PathVariable Long companyId) {
		return ratedService.listRatedByCompanyId(companyId);
	}
}
