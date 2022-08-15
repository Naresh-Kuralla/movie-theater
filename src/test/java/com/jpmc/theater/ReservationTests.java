package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.ReservationService;
import com.jpmc.theater.service.impl.ReservationServiceImpl;

public class ReservationTests {

    @Test
    void reserveTest() {
    	ReservationService reservationService =  new ReservationServiceImpl();
        var customer = new Customer("John Doe", "37248");
        var showing = new Showing(
                new Movie(0, "Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.now() 
        );
        assertEquals("success",reservationService.reserve(new Reservation(customer,showing,4,1,Math.random())) );
    }
}
