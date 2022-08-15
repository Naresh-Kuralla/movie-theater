package com.jpmc.theater.model;

import java.util.List;

import com.jpmc.theater.util.LocalDateProvider;

public class Theater {

    LocalDateProvider provider;
    private List<Showing> schedule;
    private String theaterName;
    public String getTheaterName() {
		return theaterName;
	}



	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}



	public List<Showing> getSchedule() {
		return schedule;
	}



	public void setSchedule(List<Showing> schedule) {
		this.schedule = schedule;
	}



	private int theatreNumber;

    public Theater(int theatreNumber) {
		super();
		this.theatreNumber = theatreNumber;
	}



	public int getTheatreNumber() {
		return theatreNumber;
	}



	public void setTheatreNumber(int theatreNumber) {
		this.theatreNumber = theatreNumber;
	}



	public Theater(LocalDateProvider provider) {
        this.provider = provider;
    }

  


   
}
