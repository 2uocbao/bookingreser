package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.entity.Reservation;
import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.entity.metamodel.Reservation_;
import com.quocbao.bookingreser.exception.BookingreserException;
import com.quocbao.bookingreser.repository.EmployeeRepository;
import com.quocbao.bookingreser.repository.ReservationRepository;
import com.quocbao.bookingreser.repository.ServicesRepository;
import com.quocbao.bookingreser.repository.UserRepository;
import com.quocbao.bookingreser.request.ReservationRequest;
import com.quocbao.bookingreser.service.ReservationService;

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

	@Override
	public void createReservation(ReservationRequest reservationRequest) {
		Employee employee = employeeRepository.findById(reservationRequest.getEmployeeId());
		reservationRepository.save(new Reservation(reservationRequest, employee.getCompany(), employee,
				serviceRepository.findById(reservationRequest.getServiceId()),
				userRepository.findById(reservationRequest.getUserId())));
	}

	@Override
	public void updateReservation(Long id, ReservationRequest reservationRequest) {
		Reservation reservation = reservationRepository.findById(id);
		reservation.setReservation(reservationRequest,
				!reservation.getEmployee().getId().equals(reservationRequest.getEmployeeId())
						? employeeRepository.findById(reservationRequest.getEmployeeId())
						: reservation.getEmployee(),
				!reservation.getService().getId().equals(reservationRequest.getServiceId())
						? serviceRepository.findById(id)
						: reservation.getService());
		reservationRepository.update(reservation);
	}

	@Override
	public Reservation detailReservation(Long id) {
		Reservation reservation = reservationRepository.findById(id);
		if (reservation != null) {
			throw new BookingreserException(HttpStatus.NOT_FOUND, "Reservation not found");
		}
		return reservation;
	}

	@Override
	public List<Reservation> listReservationByCompany(Long companyId) {
		return reservationRepository.getAll(Company.class, Reservation_.COMPANYID, "id", companyId);
	}

	@Override
	public List<Reservation> listReservationByUserId(Long userId) {
		return reservationRepository.getAll(User.class, Reservation_.USERID, "id", userId);
	}

}
