package bcu.cmp5332.bookingsystem.data;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingDataManager implements DataManager {
    
    public final String RESOURCE = "./resources/data/bookings.txt";

    @Override
    public void loadData(FlightBookingSystem fbs) throws IOException, FlightBookingSystemException {
        // TODO: implementation here
    	try (Scanner sc = new Scanner(new File(RESOURCE))) {
            int line_idx = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] properties = line.split(SEPARATOR, -1);
                //Object[]t = line.split(SEPARATOR, -1);;
                try {/*
                	int id2 = Integer.parseInt(properties[0]);
                    String name = properties[1];
                    String phone = properties[2];
                    Customer customer = new Customer(id2, name, phone);
                    
                	int id = Integer.parseInt(properties[3]);
                    String flightNumber = properties[4];
                    String origin = properties[5];
                    String destination = properties[6];
                    LocalDate departureDate = LocalDate.parse(properties[7]);
                    Flight flight = new Flight(id, flightNumber, origin, destination, departureDate);
                    
                    
                   
                    LocalDate bookingDate = LocalDate.parse(properties[8]);
                    Booking booking = new Booking(customer, flight, bookingDate);
                    */
                	//fbs.getcusbyID
                	int id2 = Integer.parseInt(properties[0]);
                	int id = Integer.parseInt(properties[4]);
                	
                	Customer customer = fbs.getCustomerByID(id2);
                    Flight flight = fbs.getFlightByID(id);
                    LocalDate bookingDate = LocalDate.parse(properties[11]);
                    Booking booking = new Booking(customer, flight, bookingDate);

                    customer.addBooking(booking);
                    flight.addPassenger(customer);
                    
                    
                } catch (NumberFormatException ex) {
                    throw new FlightBookingSystemException("Unable to parse booking id " + properties[0] + " on line " + line_idx
                        + "\nError: " + ex);
                }
                line_idx++;
            }
        }
    	
    	
    	
    }

    @Override
    public void storeData(FlightBookingSystem fbs) throws IOException{
        // TODO: implementation here
    	
    	
    	try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))){
    		
    		
    		for (Customer customers : fbs.getCustomers() ) {
    			for(Booking b : customers.getBookings()) {
    				
    				Customer q = b.getCustomer();
	    			Flight w = b.getFlight();
	    			
	    			
	    			out.print(q.getId() + SEPARATOR);
	                out.print(q.getName() + SEPARATOR);
	                out.print(q.phone() + SEPARATOR);
	                out.print(q.getEmail() + SEPARATOR);
	                
	                out.print(w.getId() + SEPARATOR);
	                out.print(w.getFlightNumber() + SEPARATOR);
	                out.print(w.getOrigin() + SEPARATOR);
	                out.print(w.getDestination() + SEPARATOR);
	                out.print(w.getDepartureDate() + SEPARATOR);
	                out.print(w.getCapacity() + SEPARATOR);
	                out.print(w.getPrice() + SEPARATOR);
	    			
	                out.print(b.getBookingDate());
	                out.println();
	               
    			}
    		}
        }catch(IOException ex) {
        	System.out.println(ex.getMessage());
        	System.out.println("Cancelled changes made to system!");
        }
    }
    
}
