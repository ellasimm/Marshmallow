package Database;

import FlightCode.FlightOrder;
import FlightCode.Flights;

public class DBTester {

	
	public static void main(String[] args) {
		
		Flights flight = new Flights();
		String sql = "INSERT INTO Flights (flightID, fromCity, toCity, takeOffTime, landingTime, numSeat, flightDate ) "
				+ "VALUES (212, 'Atlanta', 'Doha', '12:30pm', '2:30am', 70, '12/7/2022');";
		InsertDB.insertFlight(flight, sql);
		System.out.println("Flight added");
		// need to fix getDB to test out insertflightorder
		FlightOrder flightOrder = new FlightOrder();
		Flights booked = GetDB.getFlight(flightID);
		String sql1 = "INSERT INTO FlightOrder(flightOrderId, flightId, fromCity, toCity, flightDate, takeOffTime, landingTime, userId) "
				+ "VALUES(orderNum, flightID, booked.getFromCity(), booked.getToCity(),\r\n"
				+ "													booked.getFlightDate(), booked.getTakeOffTime(), booked.getLandingTime(),\r\n"
				+ "													LoginPageController.currentUser.getUserID());";
		String sql2 = "UPDATE Flights SET numSeat = numSeat -1 WHERE flightId=" + "'" + booked.getFlightId() + "'";
	}
}
