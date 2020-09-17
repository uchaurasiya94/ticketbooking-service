package com.deloitte.ticketbookingservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.ticketbookingservice.model.Bus;

@Repository
public interface IBusRepository extends MongoRepository<Bus, String>{

}
