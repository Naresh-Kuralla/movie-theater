package com.jpmc.theater.service.impl;

import java.util.List;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.repository.MovieRepository;
import com.jpmc.theater.service.MovieService;

public class MovieServiceImpl implements MovieService {

	MovieRepository repo = new MovieRepository();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jpmc.theater.service.MovieService#listAll()
	 */
	@Override
	public List<Movie> listAll() {

		return repo.getAllMovies();
	}

	@Override
	public Movie getById(String id) {
		return repo.getMovieById(id);
	}

	@Override
	public void delete(String id) {
		repo.delete(id);
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return repo.addMovie(movie);
	}

}
