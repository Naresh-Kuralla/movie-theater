package com.jpmc.theater.service;

import java.util.List;

import com.jpmc.theater.model.Movie;

public interface MovieService {

	 public List<Movie> listAll();
	
	 public Movie getById(String id);
	
	 public void delete(String id);
	 
	 public String addMovie(Movie movie);

}
