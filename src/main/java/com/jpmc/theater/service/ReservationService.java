package com.jpmc.theater.service;

import com.jpmc.theater.model.Reservation;

public interface ReservationService {

	String reserve(Reservation reservation);

	void cancelReservation(Double reservation);
	
	Reservation fetchReservationsByCustomer(String customerID);
}
