package bcu.cmp5332.bookingsystem.model;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Customer {
    
    private int id;
    private String name;
    private String phone;
    private final List<Booking> bookings = new ArrayList<>();
    
    private String email;
    
    // TODO: implement constructor here
    public Customer(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        
        
    }
    // TODO: implementation of Getter and Setter methods
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String phone() {
    	return phone;
    }
    
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }
    
    public void addBooking(Booking booking) throws FlightBookingSystemException { 
        // TODO: implementation here
    	if (bookings.contains(booking)) {
    		throw new FlightBookingSystemException("Booking already exists for this customer");
    	} else {
    	bookings.add(booking);
    	}
    	
    }
    
    public void cancelBookingForFlight(Flight flight) throws FlightBookingSystemException { 
    	
		for(int i = 0; i<=bookings.size(); i++) {
			Booking r = bookings.get(i);
			if(r.getFlight().equals(flight)){
				bookings.remove(i);
			}
		}
    	
	
    	}
    		
    	
    
    
    public String getDetailsShort() {
    	return "Customer #" + id + " - " + name + " - " + phone + " - " + email;
    }
    
    public String getDetailsLong() {
    	return null;
    	
    }
    
}
