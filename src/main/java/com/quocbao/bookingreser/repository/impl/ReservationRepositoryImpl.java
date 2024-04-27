package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Reservation;
import com.quocbao.bookingreser.repository.ReservationRepository;

@Repository
public class ReservationRepositoryImpl extends RepositoryImpl<Reservation> implements ReservationRepository {

	protected ReservationRepositoryImpl() {
		super(Reservation.class);
	}

}
