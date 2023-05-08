package com.quocbao.bookingreser.service;

import java.util.List;

import com.quocbao.bookingreser.entity.Reservation;
import com.quocbao.bookingreser.request.ReservationRequest;

public interface ReservationService {
	
	public void createReservation(ReservationRequest reservationRequest);

	public void updateReservation(ReservationRequest reservationRequest);

	public Reservation detailReservation(Long id);

	public List<Reservation> listReservationByCompany(Long companyId);

	public List<Reservation> listReservationByUserId(Long userId);
}
