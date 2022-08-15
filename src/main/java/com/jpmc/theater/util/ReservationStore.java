package com.jpmc.theater.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.jpmc.theater.model.Reservation;

public class ReservationStore {

	static Map<Double,Reservation> reservation;
	public static Map<Double, Reservation> getReservation() {
		return reservation;
	}
	public static void setReservation(Map<Double, Reservation> reservation) {
		ReservationStore.reservation = reservation;
	}
	static {
		 reservation = new ConcurrentHashMap<>();
	}
}
