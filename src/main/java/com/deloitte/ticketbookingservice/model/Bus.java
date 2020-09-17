package com.deloitte.ticketbookingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bus")
public class Bus {

	@Id
	private String id;
	
	private String busType;
	
	private String location;

	private int passengers;
	
	private String name;

	private Route route;
	
	private float fare;

	public Bus() {
		// TODO Auto-generated constructor stub
	}
	
	public Bus(String busType, String location, int passengers,String name, Route route,
			float fare) {
		super();
		this.busType = busType;
		this.location = location;
		this.passengers = passengers;
		this.route = route;
		this.name = name;
		this.fare = fare;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}
	
}
