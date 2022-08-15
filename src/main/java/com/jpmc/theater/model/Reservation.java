package com.jpmc.theater.model;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;
    private int theaterID;
    private double reservationID;

    public int getTheaterID() {
		return theaterID;
	}



	public void setTheaterID(int theaterID) {
		this.theaterID = theaterID;
	}



	public Reservation(Customer customer, Showing showing, int audienceCount, int theaterID, double reservationID) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
        this.theaterID = theaterID;
        this.reservationID = reservationID;
    }



	public double getReservationID() {
		return reservationID;
	}



	public void setReservationID(double reservationID) {
		this.reservationID = reservationID;
	}



	public double totalFee() {
        return showing.getMovieFee() * audienceCount;
    }

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Showing getShowing() {
		return showing;
	}

	public void setShowing(Showing showing) {
		this.showing = showing;
	}

	public int getAudienceCount() {
		return audienceCount;
	}

	public void setAudienceCount(int audienceCount) {
		this.audienceCount = audienceCount;
	}
}