package com.deloitte.ticketbookingservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.ticketbookingservice.model.Payment;

@Repository
public interface IPaymentRepository extends MongoRepository<Payment, String> {

}
