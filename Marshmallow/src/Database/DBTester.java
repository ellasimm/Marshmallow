package Database;

import FlightCode.FlightOrder;
import FlightCode.Flights;
import FlightCode.User;
import GUI.LoginPageController;

public class DBTester {
	
	public static void main(String[] args) {
		
		//Already tested insertFlight, it works
		
		//Flights flight = new Flights();
		User user = new User();
		String sql = "INSERT INTO AccountUser(UserId, userName, password, firstName, lastName, ssn, email, address, zipCode, state, securityQuestion, securityAnswer) "
				+ "VALUES(8, 'user21', 'password21', 'James', 'Burt', '111111111', 'james@gmail.com', '21 BLVd', 40122, 'Alabama', 'What is your name?', 'James Burt');";
		InsertDB.insertAccount(sql)	;		
		/**
		//String sql = "INSERT INTO Flights (flightID, fromCity, toCity, takeOffTime, landingTime, numSeat, flightDate ) "
		//		+ "VALUES (216, 'Atlanta', 'Miami', '2:40PM', '4:40PM', 50, '01/25/2023');";
		String sql = "INSERT INTO Flights (flightID, fromCity, toCity, takeOffTime, landingTime, numSeat, flightDate ) "
						+ "VALUES (218, 'Atlanta', 'San Francisco', '5:10PM', '11:00PM', 50, '02/13/2023');";
		InsertDB.insertFlight(flight, sql);
		System.out.println("Flight added");
		
		*/
		
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
