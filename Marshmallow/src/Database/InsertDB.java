package Database;  //Fix classNotFoundException

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Logger;

import FlightCode.FlightOrder;
import FlightCode.Flights;
import FlightCode.User;
import GUI.ErrorMessage;


public class InsertDB {
	public static boolean success;
	private static final Logger log = null;

	
	public static void insertFlight(Flights flight){
		success = false;
		
	
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Insert data");
			PreparedStatement preparedStatement = cnn.prepareStatement("INSERT INTO Flights (flightID, fromCity, toCity, takeOffTime, landingTime, numSeat, flightDate ) VALUES (?,?,?,?,?,?,?);");
			preparedStatement.setInt(1, flight.getFlightId());
			preparedStatement.setString(2, flight.getFromCity());
			preparedStatement.setString(3, flight.getToCity());
			preparedStatement.setString(4, flight.getTakeOffTime());
			preparedStatement.setString(5, flight.getLandingTime());
			preparedStatement.setInt(6, flight.getNumSeats());
			preparedStatement.setString(7, flight.getFlightDate());
			
			preparedStatement.executeUpdate();
			
			cnn.close();
			success = true;
								
		}catch(Exception ex) {
			System.out.println("An exception occurred in database");
			ex.printStackTrace();
			success = false;
		}
	}
	public static void insertFlightOrder(Flights order) {
		success = false;
		
		try {
			String cnnString ="jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Insert data");
			
			PreparedStatement preparedStatement = cnn.prepareStatement("INSERT INTO FlightOrder(flightOrderId, flightId, fromCity, toCity, flightDate, takeOffTime, landingTime, userId) VALUES(?,?,?,?,?,?,?,?);");
			String sql = "UPDATE Flights SET numSeat = numSeat -1 WHERE flightId=" + "'" + FlightOrder.getFlightID() + "'";
			PreparedStatement preparedStatement2 = cnn.prepareStatement(sql);
			
			preparedStatement2.executeUpdate();
			
			preparedStatement.setInt(1, FlightOrder.getOrderNumber());
			preparedStatement.setInt(2, FlightOrder.getFlightID());
			preparedStatement.setString(3, FlightOrder.getFromCity());
			preparedStatement.setString(4, FlightOrder.getToCity());
			preparedStatement.setString(5, FlightOrder.getFlightDate());
			preparedStatement.setString(6, FlightOrder.getTakeOffTime());
			preparedStatement.setString(7, FlightOrder.getLandingTime());
			preparedStatement.setInt(8, FlightOrder.getUserID());
		
		}catch(SQLIntegrityConstraintViolationException ex1) {
			
			ErrorMessage.showErrorMessage("Duplicate Booking Alert!");
			
			ex1.printStackTrace();
			success = false;
			
		}catch(SQLException ex2) {
			ex2.printStackTrace();
			success = false;
		}catch(ClassNotFoundException ex3) {
			ex3.printStackTrace();
		}
	}
	
	public void insertAccount(User user) throws SQLException{
		success = false;
	
		try {
			String cnnString = "jdbc:sqlserver://marshmallow.database.windows.net:1433;database=marshmallowDatabase;user=ellasimm@marshmallow;password=EllaOmamaReza1!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Insert data");
			
			PreparedStatement preparedStatement = cnn.prepareStatement("INSERT INTO AccountUser(accountUserId, userName, password, firstName, lastName, ssn, email, address, zipCode, state, securityQuestion, securityAnswer) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");
			preparedStatement.setInt(1, user.getUserID());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getFirstName());
			preparedStatement.setString(5, user.getLastName());
			preparedStatement.setInt(6, user.getSsn());
			preparedStatement.setString(7, user.getEmail());
			preparedStatement.setString(8, user.getAddress());
			preparedStatement.setInt(9, user.getZipCode());
			preparedStatement.setString(10, user.getState());
			preparedStatement.setString(11, user.getSecurityQuestion());
			preparedStatement.setString(12, user.getSecurityAnswer());
			
			preparedStatement.executeUpdate();
			
			cnn.close();
			success = true;
			
		}catch(SQLIntegrityConstraintViolationException ex1) {
			
			ErrorMessage.showErrorMessage("Duplicate Account Alert!" + "\nTry again or click forgot password");
			success = false;
			
		}catch(SQLException ex2) {
			ex2.printStackTrace();
			success = false;
			
		}catch(ClassNotFoundException ex3) {
			System.out.println("Might be an error in Database");
			ex3.printStackTrace();
		}
	}
}
