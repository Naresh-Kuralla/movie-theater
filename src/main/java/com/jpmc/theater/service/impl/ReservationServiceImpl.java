package com.jpmc.theater.service.impl;

import java.util.Map;

import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.service.ReservationService;
import com.jpmc.theater.util.ReservationStore;

public class ReservationServiceImpl implements ReservationService {

	
	@Override
	public String reserve(Reservation reserve) {
        
		ReservationStore.getReservation().put(reserve.getReservationID(), reserve);
        return "success";
    }

	@Override
	public void cancelReservation(Double reservationID) {
		ReservationStore.getReservation().remove(reservationID);
		
	}

	@Override
	public Reservation fetchReservationsByCustomer(String customerID) {
		Reservation res = null;
		
		Map<Double, Reservation> reservationStore = ReservationStore.getReservation();
		
		for (Double key : reservationStore.keySet()) {
	        if(reservationStore.get(key).getCustomer().getId().equalsIgnoreCase(customerID)) {
				res = reservationStore.get(key);
			}
	    }
		
		return res;
	}

}
