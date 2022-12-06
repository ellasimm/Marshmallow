package Database;

import FlightCode.Flights;

public class DBTester {

	
	public static void main(String[] args) {
		
		Flights flight = new Flights(222, "Atlanta", "Doha", "12:30pm",
				"2:30am", 80, "12/07/22");
		
		InsertDB.insertFlight(flight);
		System.out.println("Flight added");
	}
}
