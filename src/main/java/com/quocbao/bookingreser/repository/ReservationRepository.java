package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.Reservation;

public interface ReservationRepository {
	
	public Reservation createReservation(Reservation reservation);
	
	public Reservation updateReservation(Reservation reservation);
	
	public Reservation detailReservation(Long id);
	
	public List<Reservation> listReservationByCompanyId(Long companyId);
	
	public List<Reservation> listReservationByEmployeeId(Long employeeId);
	
	public List<Reservation> listReservationByServiceId(Long serviceId);
	
	public List<Reservation> listReservationByUserId(Long userId);
}
