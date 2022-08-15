package com.jpmc.theater.service.impl;

import java.util.List;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.repository.ShowRepository;
import com.jpmc.theater.service.TheaterShowService;

public class TheaterShowServiceImpl implements TheaterShowService{

	
	ShowRepository repo = new ShowRepository();
	
	
	
	public TheaterShowServiceImpl() {
	}

	@Override
	public void addShow(Movie movie) {
		repo.addShow(movie);
		
	}

	@Override
	public void deleteShow(String movieName) {
		repo.deleteShow(movieName);
		
	}

	@Override
	public List<Showing> getAllShows() {
		
		return repo.getAllShows();
	}

}
