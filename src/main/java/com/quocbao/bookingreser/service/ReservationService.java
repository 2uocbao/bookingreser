package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.request.ReservationRequest;
import com.quocbao.bookingreser.response.ReservationResponse;

public interface ReservationService {

	public void createReservation(ReservationRequest reservationRequest);

	public ReservationResponse updateReservation(Long id, ReservationRequest reservationRequest);

	public ReservationResponse detailReservation(Long id);
	
	public ReservationResponse updateStatus(String token, Long receiveId);

	public List<ReservationResponse> listReservationByCompany(Long companyId);

	public List<ReservationResponse> listReservationByUserId(Long userId);
}
