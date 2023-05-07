package com.quocbao.bookingreser.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quocbao.bookingreser.request.ReservationRequest;
import com.quocbao.bookingreser.response.ReservationResponse;

public interface ReservationService {
	
	public ResponseEntity<ReservationResponse> createReservation(ReservationRequest reservationRequest);

	public ResponseEntity<ReservationResponse> updateReservation(ReservationRequest reservationRequest);

	public ResponseEntity<ReservationResponse> detailReservation(Long id);

	public ResponseEntity<List<ReservationResponse>> listReservationByEmployeeId(Long employeeId);

	public ResponseEntity<List<ReservationResponse>> listReservationByServiceId(Long serviceId);

	public ResponseEntity<List<ReservationResponse>> listReservationByUserId(Long userId);
}
