package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import FlightCode.Flights;
import FlightCode.User;

public class InsertDB {
	public static boolean success;
	private static final Logger log = null;

	
	public static void insertFlight(Flights flight, Connection connection) throws SQLException{
		success = false;
		
	
		try {
			String cnnString = "jdbc:sqlserver://cisproject2022.database.windows.net:1433;database=FlightReservationProject;user=RezaKian@cisproject2022;password=Saglover2?;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Insert data");
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Flight (flightID, fromCity, toCity, takeOffTime, landingTime, unitCost) VALUES (?,?,?,?,?,?);");
			preparedStatement.setInt(1, flight.getFlightId());
			preparedStatement.setString(2, flight.getFromCity());
			preparedStatement.setString(3, flight.getToCity());
			preparedStatement.setString(4, flight.getTakeOffTime());
			preparedStatement.setString(5, flight.getLandingTime());
			preparedStatement.setString(6, flight.getFlightDate());
			preparedStatement.setInt(7, flight.getNumSeats());
			preparedStatement.setString(8, flight.getReturnFlight());
			
			preparedStatement.executeUpdate();
			
			connection.close();
			success = true;
								
		}catch(Exception ex) {
			System.out.println("An exception occurred in database");
			ex.printStackTrace();
			success = false;
		}
	}
	public static void insertFlightOrder(Flights order, Connection connection) throws SQLException {
		success = false;
		
		try {
			String cnnString = "jdbc:sqlserver://cisproject2022.database.windows.net:1433;database=FlightReservationProject;user=RezaKian@cisproject2022;password=Saglover2?;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			System.out.println("connecting..");
			Connection cnn = DriverManager.getConnection(cnnString);
			log.info("Insert data");
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FlightOrder(flightOrderId, flightId, subtotal, bookingstatus, accountUserId) VALUES(?,?,?,?,?);");
			
		}catch(Exception ex) {
			System.out.println("An exception occurred in database");
			ex.printStackTrace();
			success = false;
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
		}catch(Exception ex) {
			System.out.println("An exception occurred in database");
			ex.printStackTrace();
			success = false;
		}
	}
}
