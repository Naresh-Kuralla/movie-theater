package com.jpmc.theater.service;

import java.util.List;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;

public interface TheaterShowService {

	public void addShow(Movie movie);
	
	public void deleteShow(String movieName);
	
	public List<Showing> getAllShows();
}
