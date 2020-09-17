package com.deloitte.ticketbookingservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.ticketbookingservice.model.Booking;
import com.deloitte.ticketbookingservice.model.Bus;
import com.deloitte.ticketbookingservice.model.Payment;
import com.deloitte.ticketbookingservice.model.Seat;
import com.deloitte.ticketbookingservice.repositories.IBusBookingRepository;
import com.deloitte.ticketbookingservice.repositories.IBusRepository;
import com.deloitte.ticketbookingservice.repositories.IPaymentRepository;
import com.deloitte.ticketbookingservice.services.IBusBookingService;

@Service
public class BusBookingServiceImpl implements IBusBookingService {
	
	@Autowired
	private IBusRepository iBusRepository;
	
	@Autowired
	private IBusBookingRepository iBusBookingRepository;
	
	@Autowired
	private IPaymentRepository iPaymentRepository;

	@Override
	public List<Bus> getAllBus() {
		
		return iBusRepository.findAll();
	}

	@Override
	public List<Bus> getBusListByStation(String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bus> getBusListByTiming(String sourceTiming) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bus getBusById(String id) {
		
		return iBusRepository.findById(id).get();
	}

	@Override
	public String bookSeat(String busId, List<Seat> seats) {
		Bus  bus = iBusRepository.findById(busId).get();
		Booking seatBooking = new Booking();
		seatBooking.setBookingStatus("Pending");
		seatBooking.setNoOfPassengers(bus.getPassengers());
		seatBooking.setBus(bus);
		int ticketFare = seats.stream().mapToInt(x -> x.getFare()).sum();
		seatBooking.setFare(ticketFare);
		seatBooking.setSeats(seats);
		iBusBookingRepository.save(seatBooking);
		return iBusBookingRepository.save(seatBooking).getId();
	}

	@Override
	public Booking getBookingById(String bookingId) {
		
		return iBusBookingRepository.findById(bookingId).get();
	}

	@Override
	public String makePayment(String id, Payment payment) {
		Booking booking = getBookingById(id);
		String paymentId = iPaymentRepository.save(payment).getId();
		if(!paymentId.equals(null)) {
			booking.setBookingStatus("Done");
			booking.setPaymentId(paymentId);
			iBusBookingRepository.save(booking);
		}
		return paymentId;
	}

	@Override
	public List<Booking> getAllBookingByBusId(String busId) {
		List<Booking> bookingList = iBusBookingRepository.findAll().stream()
		.filter(x-> (x.getBus().getId()).equals(busId))
			.collect(Collectors.toList());
		return bookingList;
	}

	@Override
	public List<String> getBookedSeats(String busId) {
		List<Booking> bookingList = getAllBookingByBusId(busId);
		List<String> seats = bookingList.stream()
	              .flatMap(e->e.getSeats().stream())
	              .collect(Collectors.toList()).stream()
	              .map(seat->seat.getSeatNo()).collect(Collectors.toList());
		 
		return seats;
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> bookingList = iBusBookingRepository.findAll();
		return bookingList;
	}

	@Override
	public String cancelBooking(String bookingId) {
		Booking booking = getBookingById(bookingId);
		booking.setBookingStatus("Cancelled");
		iBusBookingRepository.save(booking);
		return iBusBookingRepository.save(booking).getId();
	}

}
