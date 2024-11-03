package bcu.cmp5332.bookingsystem.commands;


import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;


public class CancelBooking implements Command {

	private final int customerID; 
	private final int flightID;
	
	public CancelBooking(int id, int id2) {
		this.customerID = id;
		this.flightID = id2;
	}

	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		// TODO Auto-generated method stub
		try {
			Customer c = flightBookingSystem.getCustomerByID(customerID);
			Flight f = flightBookingSystem.getFlightByID(flightID);
			
			c.cancelBookingForFlight(f);
			f.removePassenger(c);
			
			
			System.out.println("Booking cancelled successfully!");
		}catch(FlightBookingSystemException ex) {
        	System.out.println(ex.getMessage());
        }
		
	}

}
