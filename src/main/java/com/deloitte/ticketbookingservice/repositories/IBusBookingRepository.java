package com.deloitte.ticketbookingservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.ticketbookingservice.model.Booking;

@Repository
public interface IBusBookingRepository extends MongoRepository<Booking, String> {

}
