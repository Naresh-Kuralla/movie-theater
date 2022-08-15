package com.jpmc.theater.repository;

import java.util.ArrayList;
import java.util.List;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.util.ApplicationDataFeed;

public class MovieRepository {

	List<Movie> movies = new ArrayList<>();

	public MovieRepository() {

		movies = ApplicationDataFeed.getMovies();
	}

	/**
	 * @return
	 */
	public List<Movie> getAllMovies() {

		return movies;
	}

	/**
	 * @param id
	 * @return
	 */
	public Movie getMovieById(String id) {
		return movies.stream().filter(mov -> mov.getTitle().equalsIgnoreCase(id)).findAny().orElseThrow();
	}

	/**
	 * @param id
	 */
	public void delete(String id) {
		movies.removeIf(mov -> mov.getTitle().equalsIgnoreCase(id));
	}

	/**
	 * @param movie
	 * @return
	 */
	public String addMovie(Movie movie) {
		return null;
	}

}
