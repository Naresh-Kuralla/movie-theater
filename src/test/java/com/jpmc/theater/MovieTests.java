package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jpmc.theater.service.MovieService;
import com.jpmc.theater.service.impl.MovieServiceImpl;

public class MovieTests {
    @Test
    void fetchListOfMovies() {
       MovieService movieService = new MovieServiceImpl();
     
    	assertEquals(3,   movieService.listAll().size());

    }
}
