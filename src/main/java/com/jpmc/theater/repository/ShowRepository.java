package com.jpmc.theater.repository;

import java.util.ArrayList;
import java.util.List;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.util.ApplicationDataFeed;
import com.jpmc.theater.util.LocalDateProvider;

public class ShowRepository {
	

	
	LocalDateProvider provider;
	List<Showing> schedule = new ArrayList<>();

	public ShowRepository() {
		
		schedule = ApplicationDataFeed.getSchedule();
	}


	public  List<Showing> getAllShows() {
		return schedule;
	}
	
	public void addShow(Movie movie) {
		//schedule.add(new Showing(movie, 10, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))));
	}
	
	public void deleteShow(String title) {
		schedule.removeIf(show->show.getMovie().getTitle().equalsIgnoreCase(title));
	}


}
