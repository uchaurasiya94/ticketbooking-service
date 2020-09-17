package com.deloitte.ticketbookingservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
public class Booking {

	@Id
	private String id;

	private Bus bus;

	private String location;

	private String bookingStatus;

	private int fare;

	private List<Seat> seats;

	private int noOfPassengers;

	private String paymentId;

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(String location, String bookingStatus, int fare, List<Seat> seats) {
		super();
		this.location = location;
		this.bookingStatus = bookingStatus;
		this.fare = fare;
		this.seats = seats;
	}

	public Booking(String id, Bus bus, String location, String bookingStatus, int fare, List<Seat> seats) {
		super();
		this.id = id;
		this.bus = bus;
		this.location = location;
		this.bookingStatus = bookingStatus;
		this.fare = fare;
		this.seats = seats;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

}
