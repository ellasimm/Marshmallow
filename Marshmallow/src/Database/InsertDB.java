package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import FlightCode.Flights;
import FlightCode.User;

public class InsertDB {
	public static boolean success;
	private static final Logger log;
	
	public static void main(String[] args) {
		System.out.println("performing setup..");
		String cnnString = "jdbc:sqlserver://cisproject2022.database.windows.net:1433;database=FlightReservationProject;user=RezaKian@cisproject2022;password=Saglover2?;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		
		InsertDB azure = new InsertDB();
		System.out.println("connecting..");
		insertFlight(azure, connection);
		
		
		
	}
	
	public static void insertFlight(Flights flight, String cnnString, Connection connection) throws SQLException{
		//success = false;
		//ResultSet resultSet = null;
		log.info("Insert data");
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Flight (flightID, fromCity, toCity, takeOffTime, landingTime, unitCost) VALUES(?,?,?,?,?,?); ");
		preparedStatement.setInt(1, flight.getFlightId());
		preparedStatement.setString(2, flight.getFromCity());
		preparedStatement.setString(3, flight.getToCity());
		preparedStatement.setString(4, flight.getTakeOffTime());
		preparedStatement.setString(5, flight.getLandingTime());
		preparedStatement.setString(6, flight.getFlightDate());
		preparedStatement.setInt(7, flight.getNumSeats());
		preparedStatement.setString(8, flight.getReturnFlight());
		preparedStatement.executeUpdate();
		try {
			Connection cnn = DriverManager.getConnection(cnnString);
					Statement statement = cnn.createStatement();{
						
					
		}catch(Exception ex) {
			System.out.println("something messed up in database! :-(");
			ex.printStackTrace();
			success = false;
		}
	}
	public static void insertFlightOrder(Flights order) {
		
	}
	public void insertAccount(User user) {
		
	}
	
		
	

}
