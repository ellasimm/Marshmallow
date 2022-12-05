package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Logger;

import FlightCode.Flights;
import FlightCode.User;
import GUI.ErrorMessageController;

public class InsertDB {
	public static boolean success;
	private static final Logger log = null;

	
	public static void insertFlight(Flights flight) throws SQLException{
		success = false;
		
	
		try {
			String cnnString = "jdbc:sqlserver://cisproject2022.database.windows.net:1433;database=FlightReservationProject;user=RezaKian@cisproject2022;password=Saglover2?;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Insert data");
			PreparedStatement preparedStatement = cnn.prepareStatement("INSERT INTO Flight (flightID, fromCity, toCity, takeOffTime, landingTime, flightDate ) VALUES (?,?,?,?,?,?);");
			preparedStatement.setInt(1, flight.getFlightId());
			preparedStatement.setString(2, flight.getFromCity());
			preparedStatement.setString(3, flight.getToCity());
			preparedStatement.setString(4, flight.getTakeOffTime());
			preparedStatement.setString(5, flight.getLandingTime());
			preparedStatement.setString(6, flight.getFlightDate());
			preparedStatement.setInt(7, flight.getNumSeats());
			//preparedStatement.setString(8, flight.getReturnFlight());
			
			preparedStatement.executeUpdate();
			
			cnn.close();
			success = true;
								
		}catch(Exception ex) {
			System.out.println("An exception occurred in database");
			ex.printStackTrace();
			success = false;
		}
	}
	public static void insertFlightOrder(Flights order) throws SQLException {
		success = false;
		
		try {
			String cnnString = "jdbc:sqlserver://cisproject2022.database.windows.net:1433;database=FlightReservationProject;user=RezaKian@cisproject2022;password=Saglover2?;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Insert data");
			
			PreparedStatement preparedStatement = cnn.prepareStatement("INSERT INTO FlightOrder(flightOrderId, flightId, subtotal, bookingstatus, accountUserId) VALUES(?,?,?,?,?);");
			
		}catch(SQLIntegrityConstraintViolationException ex1) {
			
			ErrorMessageController.display("Duplicate Booking Alert!");
			ex1.printStackTrace();
			success = false;
			
		}catch(SQLException ex2) {
			ex2.printStackTrace();
			success = false;
		}catch(ClassNotFoundException ex3) {
			ex3.printStackTrace();
		}
	}
	public void insertAccount(User user, Connection connection) throws SQLException{
		success = false;
	
		try {
			String cnnString = "jdbc:sqlserver://cisproject2022.database.windows.net:1433;database=FlightReservationProject;user=RezaKian@cisproject2022;password=Saglover2?;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Insert data");
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AccountUser(accountUserId, userName, password, firstName, lastName, ssn, email, address, zipCode, state, securityQuestion, securityAnswer) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");
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
			
			connection.close();
			success = true;
		}catch(SQLIntegrityConstraintViolationException ex1) {
			
			ErrorMessageController.display("Duplicate Account Alert!" + "\nTry again or click forgot password");
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
