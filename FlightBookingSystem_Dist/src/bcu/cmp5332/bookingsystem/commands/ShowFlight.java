package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class ShowFlight implements Command {

	private final int flightID; 
	
	public ShowFlight(int flightID) {
		this.flightID = flightID;
	}

	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		// TODO Auto-generated method stub
		Flight f = flightBookingSystem.getFlightByID(flightID);
		//System.out.println(f.getDetailsLong());
		
		if (f.getIfDeleted() == false) {
			System.out.println(f.getDetailsLong());
		}else {
			throw new FlightBookingSystemException("Flight is deleted");
		}
	}
}
