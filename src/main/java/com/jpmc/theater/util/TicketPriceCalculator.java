package com.jpmc.theater.util;

import java.time.LocalDateTime;

import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;

public class TicketPriceCalculator {

	public TicketPriceCalculator() {
		super();
		
	}

	private static final int MOVIE_CODE_SPECIAL = 1;

	

	public static double calculateReservationFee(Reservation reservation) {
		 Showing showing = reservation.getShowing();
		return (showing.getMovieFee() - getDiscount(showing)) * reservation.getAudienceCount();
	}

	private static double getDiscount(Showing showing) {

		var showSequence = showing.getSequenceOfTheDay();
		var specialCode = showing.getMovie().getSpecialCode();
		var ticketPrice = showing.getMovieFee();
		double specialDiscount = 0;
		double specialDiscountShowTime = 0;

		if (MOVIE_CODE_SPECIAL == specialCode) {
			specialDiscount = ticketPrice * 0.2; // 20% discount for special movie
		}
		
		LocalDateTime startTime = showing.getStartTime();
		
		if(startTime.getHour()>11 && startTime.getHour()<16) {
			specialDiscountShowTime = ticketPrice*0.25; // 25% discount for showtime between 11am & 4pm
		}

		if(specialDiscountShowTime>specialDiscount) {

			specialDiscount = specialDiscountShowTime;
		}
		
		double sequenceDiscount = 0;
		if (showSequence == 1) {
			sequenceDiscount = 3; // $3 discount for 1st show
		} else if (showSequence == 2) {

			sequenceDiscount = 2; // $2 discount for 2nd show
		} else if (showSequence == 7) {

			sequenceDiscount = 1; // $1 discount for 7th show
		}
		// biggest discount wins
		return specialDiscount > sequenceDiscount ? specialDiscount : sequenceDiscount;
	}

}
