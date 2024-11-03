package bcu.cmp5332.bookingsystem.model;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Flight {
    
    private int id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDate departureDate; 

    private final Set<Customer> passengers;
    
    private int capacity;
    private int price;

    private boolean delete = false;
    
    public Flight(int id, String flightNumber, String origin, String destination, LocalDate departureDate, int capacity, int price) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.capacity = capacity;
        this.price = price;
        
        passengers = new HashSet<>();
    }
    
    public void deleteFlight() {
    	delete = true;
    	
    }
    
    public boolean getIfDeleted() {
    	return delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
    
    public int getCapacity() {
    	return capacity;
    }
    
    public void setCapacity(int capacity) {
    	this.capacity = capacity;
    }
    
    public int getPrice() {
    	return price;
    }

    public void setPrice(int price) {
    	this.price = price;
    }
    
    public List<Customer> getPassengers() {
        return new ArrayList<>(passengers);
    }
	
    public String getDetailsShort() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return "Flight #" + id + " - " + flightNumber + " - " + origin + " to " 
                + destination + " on " + departureDate.format(dtf);
    }
    
    public void getdeets() {
    	for(Customer c : passengers) {
    		c.getDetailsShort();
    	}
    }

    public String getDetailsLong() {
        // TODO: implementation here
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    	
    	ArrayList<String> list =new ArrayList<>();
    	for (Customer c : passengers) {
    		String g = c.getDetailsShort() +"\r\n";
    		list.add(g);
    		
    	}
    	
       
    	// add new line between them
    	return "Flight #" + id + "\r\n" 
    	+ "Flight No: " + flightNumber + "\r\n" 
    	+ "Origin: " + origin + "\r\n" 
    	+ "Destination: " + destination + "\r\n" 
    	+ "Departure Date: " + departureDate.format(dtf) + "\r\n" 
    	+ "------------------" + "\r\n" 
    	+ "Passengers:" + "\r\n"
    	
    	+ String.join("", list)
    	+passengers.size() + " Passenger(s)";
    	
    	
    }
    
    public void addPassenger(Customer passenger) throws FlightBookingSystemException{
    	//bulletpoint 3 in 40% checklist
    	
    	//passengers.add(passenger);
    	
    	if (passengers.contains(passenger)) {
    		throw new FlightBookingSystemException("passenger already on this flight!");
    	} else {
    		passengers.add(passenger);
    	}
    }
    
    public void removePassenger(Customer passenger) throws FlightBookingSystemException {
    	//passengers.remove(passenger);
    	if (passengers.contains(passenger)) {
    		passengers.remove(passenger);
    	} else {
    		throw new FlightBookingSystemException("passenger is not on this flight!");
    	}
    }
}
