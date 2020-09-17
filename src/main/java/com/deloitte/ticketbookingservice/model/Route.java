package com.deloitte.ticketbookingservice.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "route")
public class Route {

	private String source;

	private String destination;

	private String dateOfJourney;

	private String sourceTiming;

	private String destinationTiming;
	
	private String duration;

	public Route() {
		// TODO Auto-generated constructor stub
	}

	public Route(String source, String destination, String sourceTiming, String destinationTiming,
			String dateOfJourney) throws ParseException {
		super();
		this.source = source;
		this.destination = destination;
		this.sourceTiming = sourceTiming;
		this.destinationTiming = destinationTiming;
		this.dateOfJourney = dateOfJourney;
		this.duration = getDuration(this.sourceTiming, this.destinationTiming);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSourceTiming() {
		return sourceTiming;
	}

	public void setSourceTiming(String sourceTiming) {
		this.sourceTiming = sourceTiming;
	}

	public String getDestinationTiming() {
		return destinationTiming;
	}

	public void setDestinationTiming(String destinationTiming) {
		this.destinationTiming = destinationTiming;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	private String getDuration(String sourceTiming, String destinationTiming) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	    Date sourceTime = format.parse(sourceTiming);
	    Date destTime = format.parse(destinationTiming);
	    long difference = destTime.getTime() - sourceTime.getTime();
	    long differenceMinutes = difference / (60 * 1000) % 60;
        long differenceHours = difference / (60 * 60 * 1000) % 24;
	    String timeTaken = String.format("%s:%s Hours",
                Long.toString(differenceHours), differenceMinutes );
	    
	    return timeTaken;
	}

}
