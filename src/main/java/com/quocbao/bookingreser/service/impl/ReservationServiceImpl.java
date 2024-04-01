package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Reservation;
import com.quocbao.bookingreser.entity.Services;
import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.entity.metamodel.Employee_;
import com.quocbao.bookingreser.entity.metamodel.Reservation_;
import com.quocbao.bookingreser.exception.BookingreserException;
import com.quocbao.bookingreser.repository.EmployeeRepository;
import com.quocbao.bookingreser.repository.ReservationRepository;
import com.quocbao.bookingreser.repository.ServicesRepository;
import com.quocbao.bookingreser.repository.UserRepository;
import com.quocbao.bookingreser.request.ReservationRequest;
import com.quocbao.bookingreser.response.ReservationResponse;
import com.quocbao.bookingreser.security.jwt.JwtTokenProvider;
import com.quocbao.bookingreser.service.ReservationService;
import com.quocbao.bookingreser.util.Status;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	ServicesRepository serviceRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Override
	public void createReservation(ReservationRequest reservationRequest) {
		Services service = serviceRepository.findById(reservationRequest.getServiceId());
		if(!service.getStatus().contentEquals(Status.EMPTY.toString())) {
			throw new BookingreserException(HttpStatus.BAD_REQUEST, "The table is already in use");
		}
		service.setStatus(Status.USED.toString());
		serviceRepository.update(service);
		reservationRepository.save(new Reservation(reservationRequest, service, userRepository.findById(reservationRequest.getUserId()), service.getCompany()));
	}

	@Override
	public ReservationResponse updateReservation(Long id, ReservationRequest reservationRequest) {
		Reservation reservation = reservationRepository.findById(id);
		reservation.setCheckinDate(reservationRequest.getCheckinDate());
		reservation.setCheckinTime(reservationRequest.getCheckinTime());
		reservation.setStatus(Status.UNCONFIRMED.toString());
		reservationRepository.update(reservation);
		return new ReservationResponse(reservation);
	}
	
	@Override
	public ReservationResponse updateStatus(String token, Long receiveId) {
		Reservation reservation = reservationRepository.findById(receiveId);
		reservation.setEmployee(employeeRepository.findByColumn(Employee_.PHONE, jwtTokenProvider.extractUsername(token)));
		reservation.setStatus(Status.SUCCESS.toString());
		reservationRepository.update(reservation);
		return new ReservationResponse(reservation);
		
	}

	@Override
	public ReservationResponse detailReservation(Long id) {
		Reservation reservation = reservationRepository.findById(id);
		if (reservation == null) {
			throw new BookingreserException(HttpStatus.NOT_FOUND, "Reservation not found");
		}
		return new ReservationResponse(reservation);
	}

	@Override
	public List<ReservationResponse> listReservationByCompany(Long companyId) {
		return new ReservationResponse().reservationResponses(
				reservationRepository.getAll(Company.class, Reservation_.COMPANYID, "id", companyId.toString()));
	}

	@Override
	public List<ReservationResponse> listReservationByUserId(Long userId) {
		return new ReservationResponse().reservationResponses( reservationRepository.getAll(User.class, Reservation_.USERID, "id", userId.toString()));
	}

}
