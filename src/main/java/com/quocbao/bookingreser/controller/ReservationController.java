package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.common.DataResponse;
import com.quocbao.bookingreser.request.ReservationRequest;
import com.quocbao.bookingreser.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@PostMapping("/create")
	ResponseEntity<DataResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {
		reservationService.createReservation(reservationRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<DataResponse> detailReservation(@PathVariable Long id) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, reservationService.detailReservation(id)),
				HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<DataResponse> updateReservation(@PathVariable Long id,
			@RequestBody ReservationRequest reservationRequest) {
		reservationService.updateReservation(id, reservationRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/byCompany/{companyId}")
	ResponseEntity<DataResponse> getByCompany(@PathVariable Long companyId) {
		return new ResponseEntity<>(
				new DataResponse(HttpStatus.OK, reservationService.listReservationByCompany(companyId)), HttpStatus.OK);
	}

	@GetMapping("/byUser/{userId}")
	ResponseEntity<DataResponse> getByUser(@PathVariable Long userId) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, reservationService.listReservationByUserId(userId)),
				HttpStatus.OK);
	}
}
