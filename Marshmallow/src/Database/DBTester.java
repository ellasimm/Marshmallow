package Database;

import FlightCode.Flights;

public class DBTester {

	
	public static void main(String[] args) {
		
		Flights flight = new Flights();
		String sql = "INSERT INTO Flights (flightID, fromCity, toCity, takeOffTime, landingTime, numSeat, flightDate ) "
				+ "VALUES (212, 'Atlanta', 'Doha', '12:30pm', '2:30am', 70, '12/7/2022');";
		InsertDB.insertFlight(flight, sql);
		System.out.println("Flight added");
	}
}
