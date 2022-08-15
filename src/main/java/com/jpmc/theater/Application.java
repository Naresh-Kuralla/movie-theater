package com.jpmc.theater;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.ReservationService;
import com.jpmc.theater.service.TheaterShowService;
import com.jpmc.theater.service.impl.ReservationServiceImpl;
import com.jpmc.theater.service.impl.TheaterShowServiceImpl;
import com.jpmc.theater.util.LocalDateProvider;
import com.jpmc.theater.util.TicketPriceCalculator;

public class Application {

	LocalDateProvider provider = LocalDateProvider.singleton();

	public static void main(String[] args) throws JsonProcessingException {
		Application app = new Application();
		TheaterShowService service = new TheaterShowServiceImpl();
		ReservationService reservationService =  new ReservationServiceImpl();
		List<Showing> shows = service.getAllShows();
		Customer john = new Customer("John Doe", "id-12345");
		Reservation reservation = new Reservation(john,shows.get(0),4,1,Math.random());
		reservationService.reserve(reservation);
		TicketPriceCalculator calculator = new TicketPriceCalculator();
		calculator.calculateReservationFee(reservation);
		app.printSchedule(shows);

		app.printScheduleInJson(shows);

	}

	private void printScheduleInJson(List<Showing> shows) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		System.out.println(provider.currentDate());
		System.out.println("===================================================");
		System.out.println(mapper.writeValueAsString(shows));
		System.out.println("===================================================");

	}

	public void printSchedule(List<Showing> schedule) {

		System.out.println(provider.currentDate());
		System.out.println("===================================================");
		schedule.forEach(s -> System.out
				.println(s.getSequenceOfTheDay() + ": " + s.getStartTime() + " " + s.getMovie().getTitle() + " "
						+ humanReadableFormat(s.getMovie().getRunningTime()) + " $" + s.getMovieFee()));
		System.out.println("===================================================");
	}

	public String humanReadableFormat(Duration duration) {
		long hour = duration.toHours();
		long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

		return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin,
				handlePlural(remainingMin));
	}

	// (s) postfix should be added to handle plural correctly
	private String handlePlural(long value) {
		if (value == 1) {
			return "";
		} else {
			return "s";
		}
	}

}
