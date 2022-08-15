package com.jpmc.theater.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;

public class ApplicationDataFeed {

	static List<Movie> movies = new ArrayList<>();
	static Movie theBatMan;
	static Movie turningRed;
	static Movie spiderMan;
	
	public static List<Movie> getMovies(){
		 spiderMan = new Movie(1,"Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
         turningRed = new Movie(2,"Turning Red", Duration.ofMinutes(85), 11, 0);
         theBatMan = new Movie(3,"The Batman", Duration.ofMinutes(95), 9, 0);
        
        movies.add(spiderMan);
        movies.add(turningRed);
        movies.add(theBatMan);
        
        return movies;
		
	}
	
	public static List<Showing> getSchedule(){
		LocalDateProvider provider = LocalDateProvider.singleton();
		getMovies();

		return List.of(
	            new Showing(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
	            new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
	            new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
	            new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
	            new Showing(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
	            new Showing(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
	            new Showing(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
	            new Showing(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
	            new Showing(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0)))
	            );
}
	
}
