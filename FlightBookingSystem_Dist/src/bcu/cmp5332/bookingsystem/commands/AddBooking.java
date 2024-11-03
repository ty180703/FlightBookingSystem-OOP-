package bcu.cmp5332.bookingsystem.commands;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class AddBooking implements Command {
	
	
	private final int customerID; 
	private final int flightID;
	//private final LocalDate	bookingDate;
	
	public AddBooking(int customerID,int flightID) {
		this.customerID = customerID;
		this.flightID = flightID;
		//this.bookingDate = bookingDate;
	}
	
	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		// TODO Auto-generated method stub
	
		Customer c = flightBookingSystem.getCustomerByID(customerID);
		Flight f = flightBookingSystem.getFlightByID(flightID);
		
		LocalDate date = LocalDate.now();
		Booking b = new Booking(c, f, date);
		
		
		c.addBooking(b);
		f.addPassenger(c);
		System.out.println("Booking issued Successfully!");
		
	}

}
