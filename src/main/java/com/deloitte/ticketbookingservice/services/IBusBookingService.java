package com.deloitte.ticketbookingservice.services;

import java.util.List;

import com.deloitte.ticketbookingservice.model.Booking;
import com.deloitte.ticketbookingservice.model.Bus;
import com.deloitte.ticketbookingservice.model.Payment;
import com.deloitte.ticketbookingservice.model.Seat;

public interface IBusBookingService {

	public List<Bus> getAllBus();
	
	public List<Bus> getBusListByStation(String source, String destination);
	
	public List<Bus> getBusListByTiming(String sourceTiming);
	
	public Bus getBusById(String id);
	
	public String bookSeat(String busId, List<Seat> seats);
	
	public Booking getBookingById(String bookingId);

	public String makePayment(String id, Payment payment);
	
	public List<Booking> getAllBookingByBusId(String busId);

	public List<String> getBookedSeats(String busId);

	public List<Booking> getAllBookings();

	public String cancelBooking(String bookingId);

}
