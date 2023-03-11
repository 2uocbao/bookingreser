package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.entity.Reservation;
import com.quocbao.bookingreser.entity.Service;
import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.repository.ReservationRepository;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

public class ReservationRepositoryImpl extends AbstractRepository<Reservation> implements ReservationRepository {

	@Override
	public Reservation createReservation(Reservation reservation) {
		return this.create(reservation);
	}

	@Override
	public Reservation updateReservation(Reservation reservation) {
		return this.update(reservation);
	}

	@Override
	public Reservation detailReservation(Long id) {
		return this.detail(id);
	}

	@Override
	public List<Reservation> listReservationByCompanyId(Long companyId) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Reservation> criteria = builder.createQuery(Reservation.class);
		Root<Company> translation = criteria.from(Company.class);
		Path<Reservation> path = translation.get("company");
		criteria.select(path);
		criteria.where(builder.equal(translation.get("id"), companyId));
		TypedQuery<Reservation> query = this.entityManager.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public List<Reservation> listReservationByEmployeeId(Long employeeId) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Reservation> criteria = builder.createQuery(Reservation.class);
		Root<Employee> translation = criteria.from(Employee.class);
		Path<Reservation> path = translation.get("employee");
		criteria.select(path);
		criteria.where(builder.equal(translation.get("id"), employeeId));
		TypedQuery<Reservation> query = this.entityManager.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public List<Reservation> listReservationByServiceId(Long serviceId) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Reservation> criteria = builder.createQuery(Reservation.class);
		Root<Service> translation = criteria.from(Service.class);
		Path<Reservation> path = translation.get("service");
		criteria.select(path);
		criteria.where(builder.equal(translation.get("id"), serviceId));
		TypedQuery<Reservation> query = this.entityManager.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public List<Reservation> listReservationByUserId(Long userId) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Reservation> criteria = builder.createQuery(Reservation.class);
		Root<User> translation = criteria.from(User.class);
		Path<Reservation> path = translation.get("user");
		criteria.select(path);
		criteria.where(builder.equal(translation.get("id"), userId));
		TypedQuery<Reservation> query = this.entityManager.createQuery(criteria);
		return query.getResultList();
	}
}
