package com.deloitte.ticketbookingservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ticketbookingservice.model.Booking;
import com.deloitte.ticketbookingservice.model.Bus;
import com.deloitte.ticketbookingservice.model.Payment;
import com.deloitte.ticketbookingservice.model.Route;
import com.deloitte.ticketbookingservice.model.Seat;
import com.deloitte.ticketbookingservice.repositories.IBusRepository;
import com.deloitte.ticketbookingservice.services.IBusBookingService;

@RestController
public class BusBookingController {

	@Autowired
	private IBusBookingService busBookingService;

	
	@GetMapping("/buses")
	public ResponseEntity<?> getAllBuses(){
		List<Bus> busList = busBookingService.getAllBus();
		return new ResponseEntity<List<Bus>>(busList, HttpStatus.OK);
	}
	
	@GetMapping("/bus")
	public ResponseEntity<?> getAllBusById(@RequestParam("id") String id){
		Bus bus = busBookingService.getBusById(id);
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}
	
	@GetMapping("/booking")
	public ResponseEntity<?> getBookingById(@RequestParam("id") String bookingId){
		Booking booking = busBookingService.getBookingById(bookingId);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}
	
	@GetMapping("/allbookings")
	public ResponseEntity<?> getAllBookings(){
		List<Booking> bookings = busBookingService.getAllBookings();
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
	}
	
	@GetMapping("/bookings")
	public ResponseEntity<?> getBookingsByBusId(@RequestParam("id") String busId){
		List<Booking> bookings = busBookingService.getAllBookingByBusId(busId);
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
	}
	
	
	@GetMapping("/bookedseat")
	public ResponseEntity<?> getBookedSeatByBusId(@RequestParam("id") String busId){
		List<String> seats = busBookingService.getBookedSeats(busId);
		return new ResponseEntity<List<String>>(seats, HttpStatus.OK);
	}
	
	
	@GetMapping("/cancelbooking")
	public ResponseEntity<?> cancelBookingById(@RequestParam("id") String bookingId){
		String bookingiD = busBookingService.cancelBooking(bookingId);
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("id", bookingiD);
		return new ResponseEntity<Map>(responseMap,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/buses")
	public ResponseEntity<?> addBus(@RequestBody Bus bus){
		Route route = new Route();
		route.setDestination("Delhi");
		route.setSource("Mumbai");
		bus.setRoute(route);
		//iBookingRepository.save(bus);
		
		return new ResponseEntity<String>("Bus Information saved Successfully", HttpStatus.OK);
	}
	
	@PostMapping(path = "/bookseat", consumes = "application/json")
	public ResponseEntity<?> bookSeat(@RequestParam("id") String id, @RequestBody List<Seat> seats) throws JSONException{
		
		String bookingId = busBookingService.bookSeat(id, seats);
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("id", bookingId);
		return new ResponseEntity<Map>(responseMap,HttpStatus.OK);
	}
	
	@PostMapping(path = "/payment", consumes = "application/json")
	public ResponseEntity<?> makePayment(@RequestParam("id") String id, @RequestBody Payment payment) throws JSONException{
		
		String paymentId = busBookingService.makePayment(id, payment);
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("id", paymentId);
		return new ResponseEntity<Map>(responseMap,HttpStatus.OK);
	}
	
}
