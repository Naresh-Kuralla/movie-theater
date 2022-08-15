package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.util.TicketPriceCalculator;

public class TicketPriceCalculatorTest {

	
	 @Test
	    void specialShowTime25Discount() {
	        Movie spiderMan = new Movie(1, "Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
	        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.NOON));
	        Customer john = new Customer("John Doe", "id-12345");
			Reservation reservation = new Reservation(john,showing,4,1,Math.random());
	        assertEquals(37.5, TicketPriceCalculator.calculateReservationFee(reservation));

	    }
}
