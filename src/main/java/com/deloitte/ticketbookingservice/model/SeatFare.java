package com.deloitte.ticketbookingservice.model;

public enum SeatFare {
	AC  (1500), 
    NonAC(800);

    private final int busFare;

    SeatFare(int busFare) {
        this.busFare = busFare;
    }
    
    public int getSeatFareBasedOnBusType() {
        return this.busFare;
    }
}
