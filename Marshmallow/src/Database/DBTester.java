package Database;

import FlightCode.FlightOrder;
import FlightCode.Flights;
import FlightCode.User;
import GUI.LoginPageController;

public class DBTester {
	
	public static void main(String[] args) {
		
		//Already tested insertFlight, it works
		
		
		
		
		
		//need to test out insertflightorder
		
		//FlightOrder flightOrder = new FlightOrder();
		
		//String sql1 = "INSERT INTO FlightOrder(flightOrderId, flightId, fromCity, toCity, flightDate, takeOffTime, landingTime, userId) "
		//		+ "VALUES(016, 212, 'Atlanta', 'Doha', '12/7/2022', '12:30pm', '2:30am', 3);";
		//String sql2 = "INSERT INTO FlightOrder(flightOrderId, flightId, fromCity, toCity, flightDate, takeOffTime, landingTime, userId) "
		//		+ "VALUES(016, 212, 'Atlanta', 'Doha', '12/7/2022', '12:30pm', '2:30am', '" + LoginPageController.currentUser.getUserID()+"' );";
		
		//InsertDB.insertFlightOrder(flightOrder);
		//int orderId = 216;
		//String sql = "DELETE * FROM FlightOrder WHERE flightOrderId = 216 ;" ;
		//UpdateDB.deleteFlightOrder(flightOrder, sql);
	}
}
